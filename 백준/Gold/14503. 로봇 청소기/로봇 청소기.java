import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static boolean[][] map;
    public static boolean[][] done;
    public static int rx, ry, rdir;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int cleancnt = 0;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 방 크기 입력, 관련변수 초기화
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        done = new boolean[N][M];

        // 로봇청소기 위치, 방향 입력
        st = new StringTokenizer(br.readLine(), " ");
        rx = Integer.parseInt(st.nextToken());
        ry = Integer.parseInt(st.nextToken());
        rdir = Integer.parseInt(st.nextToken());

        // 방 정보 입력
        // 벽인 경우(done에서는 청소를 할 필요가 없는 경우) true로 표시
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                if(st.nextToken().equals("1")) {
                    map[i][j] = true;
                    done[i][j] = true;
                }
            }
        }
        
        clean();
        System.out.print(cleancnt);

    }

    public static void clean() {
    	// 현재칸 청소
    	if(!done[rx][ry]) cleancnt++;
    	done[rx][ry] = true;
    	
    	int startdir = (4 - rdir) % 4;
        int backdir = (startdir + 1) % 4;
        int backx = rx + dx[backdir];
        int backy = ry + dy[backdir];
        
        if(!canMove()) {
//        	if(OOB(backx, backy) || map[backx][backy])
//        		return;
        	if(map[backx][backy]) return;
        	else {
        		rx = backx;
        		ry = backy;
        		clean();
        	}
        }
        else {
        	while(true) {
        		int nx = rx + dx[startdir];
        		int ny = ry + dy[startdir];
//        		if(OOB(nx, ny)) {
//        			startdir = (startdir + 1) % 4;
//        			rdir = (rdir + 3) % 4;
//        			continue;
//        		}
        		if(!done[nx][ny]) {
        			rx = nx;
        			ry = ny;
        			rdir = (rdir + 3) % 4;
        			break;
        		}
        		startdir = (startdir + 1) % 4;
        		rdir = (rdir + 3) % 4;
        	}
        	clean();
        }
    }

    // 상하좌우 방향으로 청소할 수 있는 칸이 있는지 판별
    public static boolean canMove() {
        for(int dir = 0; dir < 4; dir++) {
            int x = rx + dx[dir];
            int y = ry + dy[dir];
            
            //if(OOB(x, y)) continue;
            if(!done[x][y])
                return true;
        }
        
        return false;
    }
    
    // 영역을 벗어나는지를 체크
    public static boolean OOB(int x, int y) {
        return x < 0 || x >= M || y < 0 || y >= N;
    }
    
}