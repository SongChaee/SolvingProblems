import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int from;
	int to;
	int weight;
	
	public Node(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node n) {
		return weight - n.weight;
	}
}

public class Main {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, M;
	static int[][] map;
	static int[] p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int c = 0; c < M; c++)
				map[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// step1. 섬을 1부터 N까지 인덱싱
		boolean[][] visit = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		int idx = 1;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] == 1 && !visit[r][c]) {
					q.add(new int[] {r, c});
					while(!q.isEmpty()) {
						int[] now = q.poll();
						map[now[0]][now[1]] = idx;
						for(int dir = 0; dir < 4; dir++) {
							int nx = now[0] + dx[dir];
							int ny = now[1] + dy[dir];
							if(OOB(nx, ny)) continue;
							if(visit[nx][ny]) continue;
							if(map[nx][ny] == 1) {
								q.add(new int[] {nx, ny});
								visit[nx][ny] = true;
							}
						}
					}
					idx++;
				}
			}
		}
		
		// step2. 각 섬을 연결할 수 있는 모든 다리 계산
		ArrayList<Node> graph = new ArrayList<>();
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] != 0) {
					int fromIdx = map[r][c];
					for(int dir = 0; dir < 4; dir++) {
						int x = r;
						int y = c;
						int len = 0;
						while(true) {
							x += dx[dir];
							y += dy[dir];
							len++;
							if(OOB(x, y)) break;
							if(map[x][y] == fromIdx) break;
							if(map[x][y] != 0) {
								if(len == 2) break;
								int toIdx = map[x][y];
								graph.add(new Node(fromIdx, toIdx, len - 1));
								break;
							}
						}
					}
				}
			}
		}
		
		// step3. kruskal 알고리즘 적용
		p = new int[idx];
		for(int i = 0; i < idx; i++)
			p[i] = i;
		
		Collections.sort(graph);
		
		int ans = 0;
		for(Node n : graph) {
			int from = n.from;
			int to = n.to;
			int weight = n.weight;
			
			if(find(from) == find(to))
				continue;
			
			ans += weight;
			union(from, to);
		}
		
		// step4. 모든 섬이 연결되었는지 확인 후 결과 출력
		for(int i = 1; i < idx; i++)
			p[i] = find(i);
		
		boolean flag = true;
		int parent = p[1];
		for(int i = 2; i < idx; i++) {
			if(p[i] != parent) {
				flag = false;
				break;
			}
		}
		System.out.print(flag ? ans : -1);
	}
	
	public static int find(int x) {
		if(x != p[x])
			p[x] = find(p[x]);
		return p[x];
	}
	
	public static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(px != py)
			p[py] = px;
	}
	
	public static boolean OOB(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M)
			return true;
		return false;
	}
}