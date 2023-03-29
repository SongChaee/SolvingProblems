import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		LinkedList<int[]> game = new LinkedList<>();
		
		for(int i = 1; i <= N; i++)
			game.add(new int[] {i, 0});
		
		boolean clockwise = true;
		int cnt = 0;
		
		int[] first = game.poll();
		if(first[1] + 1 == M) {
			System.out.print(cnt);
			return;
		}
		if(first[1] + 1 % 2 == 0) clockwise = false; 
		game.addFirst(new int[] {first[0], first[1] + 1});
		
		while(!game.isEmpty()) {
			if(clockwise) {
				for(int i = 0; i < L; i++)
					game.add(game.poll());
				int[] turn = game.poll();
				cnt++;
				if((turn[1] + 1) % 2 == 0) clockwise = false;
				if(turn[1] + 1 == M) break;
				game.addFirst(new int[] {turn[0], turn[1] + 1});
			}else {
				for(int i = 0; i < L-1; i++)
					game.addFirst(game.pollLast());
				int[] turn = game.pollLast();
				cnt++;
				if((turn[1] + 1) % 2 != 0) clockwise = true;
				if(turn[1] + 1 == M) break;
				game.addFirst(new int[] {turn[0], turn[1] + 1});
			}
		}
		
		System.out.print(cnt);
	}
}