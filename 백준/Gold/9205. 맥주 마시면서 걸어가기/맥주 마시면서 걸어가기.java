import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static int storeN;
	public static int[][] location;
	public static boolean[] visit;
	public static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int tc = 0; tc < T; tc++) {
			storeN = Integer.parseInt(br.readLine());

			location = new int[storeN + 2][2];

			for (int n = 0; n < storeN + 2; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				location[n][0] = Integer.parseInt(st.nextToken());
				location[n][1] = Integer.parseInt(st.nextToken());
			}

			graph = new ArrayList<>();
			for (int n = 0; n < storeN + 2; n++)
				graph.add(new ArrayList<>());

			for (int i = 0; i < storeN + 2; i++) {
				for (int j = i + 1; j < storeN + 2; j++) {
					if (Math.abs(location[i][0] - location[j][0]) + Math.abs(location[i][1] - location[j][1]) <= 1000) {
						graph.get(i).add(j);
						graph.get(j).add(i);
					}
				}
			}

			bfs();
		}
		
		System.out.print(sb.toString());
	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		visit = new boolean[storeN + 2];

		q.add(0);
		visit[0] = true;

		while (!q.isEmpty()) {
			int check = q.poll();
			
			if (check == storeN + 1) {
				sb.append("happy").append("\n");
				return;
			}
			
			for(int next : graph.get(check)) {
				if(!visit[next]) {
					q.add(next);
					visit[next] = true;
				}
			}
		}
		
		sb.append("sad").append("\n");
		return;
	}
}
