import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int M = sc.nextInt();
			int N = sc.nextInt();
			int Holex = sc.nextInt();
			int Holey = sc.nextInt();
			int time = sc.nextInt();
			
			int[][] map = new int[M][N];
			boolean[][] visit = new boolean[M][N];
			int cnt = 0;
			
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {Holex, Holey, 1});
			visit[Holex][Holey] = true;
			
			while(!q.isEmpty()) {
				int[] check = q.poll();
				int cx = check[0];
				int cy = check[1];
				
				if(check[2] > time) break;
				cnt++;
				
				for(int dir = 0; dir < 4; dir++) {
					int x = check[0] + dx[dir];
					int y = check[1] + dy[dir];
					
					if(x < 0 || x >= M || y < 0 || y >= N) continue;
					if(map[x][y] == 0 || visit[x][y]) continue;
					
					// 1. 상하좌우 터널의 경우 > dir=0 일때는 다음 map=3,4,7이면 연결 불가능
					//						dir=1 일때는 다음 map=3,5,6이면 연결 불가능
					//						dir=2 일때는 다음 map=2,6,7이면 연결 불가능
					//						dir=3 일때는 다음 map=2,4,5이면 연결 불가능
					if(map[cx][cy] == 1) {
						if(dir == 0 && (map[x][y] == 3 || map[x][y] == 4 || map[x][y] == 7))
							continue;
						else if(dir == 1 && (map[x][y] == 3 || map[x][y] == 5 || map[x][y] == 6))
							continue;
						else if(dir == 2 && (map[x][y] == 2 || map[x][y] == 6 || map[x][y] == 7))
							continue;
						else if(dir == 3 && (map[x][y] == 2 || map[x][y] == 4 || map[x][y] == 5))
							continue;
					}
					
					// 2. 상하 터널의 경우 > dir=0 일때는 다음 map=3,4,7이면 연결 불가능
					//					dir=1일때는 다음 map=3,5,6이면 연결 불가능
					else if(map[cx][cy] == 2) {
						if(dir > 1) continue;
						if(dir == 0 && (map[x][y] == 3 || map[x][y] == 4 || map[x][y] == 7))
							continue;
						else if(dir == 1 && (map[x][y] == 3 || map[x][y] == 5 || map[x][y] == 6))
							continue;
					}
					
					// 3. 좌우 터널의 경우 > dir=2 일때는 다음 map=2,6,7이면 연결 불가능
					//					dir=3 일때는 다음 map=2,4,5이면 연결 불가능
					else if(map[cx][cy] == 3) {
						if(dir < 2) continue;
						if(dir == 2 && (map[x][y] == 2 || map[x][y] == 6 || map[x][y] == 7))
							continue;
						else if(dir == 3 && (map[x][y] == 2 || map[x][y] == 4 || map[x][y] == 5))
							continue;
					}
					
					// 4. 상우 터널의 경우 > dir=0 일때는 다음 map=3,4,7이면 연결 불가능
					//					dir=3일때는 다음 map=2,4,5이면 연결 불가능
					else if(map[cx][cy] == 4) {
						if(dir == 1 || dir == 2) continue;
						if(dir == 0 && (map[x][y] == 3 || map[x][y] == 4 || map[x][y] == 7))
							continue;
						else if(dir == 3 && (map[x][y] == 2 || map[x][y] == 4 || map[x][y] == 5))
							continue;
					}
					
					// 5. 하우 터널의 경우 > dir=1 일때는 다음 map=3,5,6이면 연결 불가능
					//					dir=3 일때는 다음 map=2,4,5이면 연결 불가능
					else if(map[cx][cy] == 5) {
						if(dir == 0 || dir == 2) continue;
						if(dir == 1 && (map[x][y] == 3 || map[x][y] == 5 || map[x][y] == 6))
							continue;
						else if(dir == 3 && (map[x][y] == 2 || map[x][y] == 4 || map[x][y] == 5))
							continue;
					}
					
					// 6. 하좌 터널의 경우 > dir=1 일때는 다음 map=3,5,6이면 연결 불가능
					//					dir=2 일때는 다음 map=2,6,7이면 연결 불가능
					else if(map[cx][cy] == 6) {
						if(dir == 0 || dir == 3)
							continue;
						if(dir == 1 && (map[x][y] == 3 || map[x][y] == 5 || map[x][y] == 6))
							continue;
						else if(dir == 2 && (map[x][y] == 2 || map[x][y] == 6 || map[x][y] == 7))
							continue;
					}
					
					// 7. 상좌 터널의 경우 > dir=0 일때는 다음 map=3,4,7이면 연결 불가능
					//					dir=2 일때는 다음 map=2,6,7이면 연결 불가능
					else if(map[cx][cy] == 7){
						if(dir == 1 || dir == 3) continue;
						if(dir == 0 && (map[x][y] == 3 || map[x][y] == 4 || map[x][y] == 7))
							continue;
						else if(dir == 2 && (map[x][y] == 2 || map[x][y] == 6 || map[x][y] == 7))
							continue;
					}

					q.add(new int[] {x, y, check[2] + 1});
					visit[x][y] = true;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb.toString());
	}
}