import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, K;
	public static int[] belt;
	public static boolean[] robot;
	public static int cntZero = 0;
	public static int level = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		belt = new int[N * 2];
		robot = new boolean[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 2 * N; i++)
			belt[i] = Integer.parseInt(st.nextToken());
		
		while(!end()) {
			rotate();
			move();
			putRobot();
			level++;
		}
		
		System.out.print(level);
	}
	
	public static void putRobot() {
		if(belt[0] > 0) {
			robot[0] = true;
			belt[0]--;
			if(isZero(0)) cntZero++;
		}
	}
	
	public static void rotate() {
		int temp = belt[2 * N - 1];
		for(int i = 2 * N - 1; i > 0; i--)
			belt[i] = belt[i - 1];
		belt[0] = temp;
		
		for(int i = N - 1; i > 0; i--)
			robot[i] = robot[i - 1];
		robot[0] = false;
		robot[N - 1] = false;
	}
	
	public static void move() {
		for(int i = N - 1; i > 0; i--) {
			if(robot[i - 1] && !robot[i] && belt[i] > 0) {
				belt[i]--;
				if(isZero(i)) cntZero++;
				robot[i] = true;
				robot[i - 1] = false;
			}
		}
	}
	
	public static boolean end() {
		if(cntZero >= K)
			return true;
		return false;
	}
	
	public static boolean isZero(int idx) {
		if(belt[idx] <= 0)
			return true;
		return false;
	}
}