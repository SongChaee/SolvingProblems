import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 지도 높이, 너비
	public static char[][] map;
	public static int h;
	public static int w;
	// 열쇠 보유 여부
	public static boolean[] haveKey;
	// 지도에서 출발 가능한 지점
	public static Queue<int[]> start;
	// 지도에서 발견한 문
	public static Queue<int[]> door;
	// 상하좌우 탐색
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	// 방문 여부 확인
	public static boolean[][] visit;
	// 찾은 문서의 개수
	public static int docsN;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		// 테스트케이스 반복 수행
		StringTokenizer st;
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			visit = new boolean[h][w];
			
			start = new LinkedList<>();
			door = new LinkedList<>();
			haveKey = new boolean[26];
			docsN = 0;
			
			// 지도 정보 입력
			for(int r = 0; r < h; r++) {
				String input = br.readLine();
				for(int c = 0; c < w; c++) {
					char ch = input.charAt(c);
					map[r][c] = ch;
					// 탐색 가능 시작점 좌표 저장
					if(r == 0 || r == h - 1 || c == 0 || c == w - 1) {
						if(ch == '.') {
							start.add(new int[] {r, c});
							visit[r][c] = true;
						}
						// 시작점에 문서가 존재하는 경우
						else if(ch == '$') {
							docsN++;
							start.add(new int[] {r, c});
							visit[r][c] = true;
						}
						// 시작점에 열쇠가 존재하는 경우
						else if(ch - 'a' >= 0 && ch - 'a' < 26) {
							haveKey[ch - 'a'] = true;
							start.add(new int[] {r, c});
							visit[r][c] = true;
						}
						// 시작점에 문이 존재하는 경우
						else if(ch - 'A' >= 0 && ch - 'A' < 26) {
							door.add(new int[] {r, c});
						}
					}
				}
			}
			
			// 초기에 가지고 있는 열쇠 입력
			String keyInfo = br.readLine();
			if(!keyInfo.equals("0")) {
				for(int i = 0; i < keyInfo.length(); i++) {
					haveKey[keyInfo.charAt(i) - 'a'] = true;
				}
			}
			
			// 초기에 가지고 있는 열쇠로 시작점이 문인 경우를 열 수 있을 때
			// 해당 좌표를 시작점에 추가
			for(int i = 0; i < door.size(); i++) {
				int[] check = door.poll();
				if(canOpen(check[0], check[1])) {
					start.add(new int[] {check[0], check[1]});
					visit[check[0]][check[1]] = true;
				}
				door.add(check);
			}
			
			// 획득할 수 있는 문서 탐색
			find();
			sb.append(docsN).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void find() {
		int startN = start.size();
		
		Queue<int[]> find = new LinkedList<>();
		for(int i = 0; i < startN; i++) {
			int[] st = start.poll();
			find.add(st);
			
			while(!find.isEmpty()) {
				int[] check = find.poll();
				
				// 상하좌우 탐색
				for(int dir = 0; dir < 4; dir++) {
					int nx = check[0] + dx[dir];
					int ny = check[1] + dy[dir];
					if(out(nx, ny)) continue;
					if(visit[nx][ny] || map[nx][ny] == '*') continue;
					// 열 수 없는 문이 존재하는 경우
					if(isDoor(nx, ny) && !canOpen(nx, ny)) {
						door.add(new int[] {nx, ny});
						continue;
					}
					// 열쇠가 존재하는 경우
					if(isKey(nx, ny)) {
						haveKey[map[nx][ny] - 'a'] = true;
						// 이전에 방문했던 문 중 열 수 있는 문이 있는지 확인
						for(int doorN = 0; doorN < door.size(); doorN++) {
							int[] dcheck = door.poll();
							if(canOpen(dcheck[0], dcheck[1])) {
								find.add(new int[] {dcheck[0], dcheck[1]});
								visit[dcheck[0]][dcheck[1]] = true;
							}
							door.add(dcheck);
						}
					}
					// 문서가 존재하는 경우
					if(map[nx][ny] == '$') {
						docsN++;
					}
					find.add(new int[] {nx, ny});
					visit[nx][ny] = true;
				}
			}
			start.add(st);
		}
	}
	
	// 문 여부 판단
	public static boolean isDoor(int x, int y) {
		if(map[x][y] - 'A' >= 0 && map[x][y] - 'A' < 26)
			return true;
		return false;
	}
	
	// 열쇠 여부 판단
	public static boolean isKey(int x, int y) {
		if(map[x][y] - 'a' >= 0 && map[x][y] - 'a' < 26)
			return true;
		return false;
	}
	
	// 문 개방 가능 여부 판단
	public static boolean canOpen(int x, int y) {
		
		if(haveKey[map[x][y] - 'A'])
			return true;
		return false;
	}
	
	// 지도 좌표를 벗어나는지 여부 판단
	public static boolean out(int x, int y) {
		if(x < 0 || x >= h || y < 0 || y >= w)
			return true;
		return false;
	}
}