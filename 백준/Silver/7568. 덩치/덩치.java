import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Person[] list = new Person[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			list[i] = new Person(w, h);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				if(list[i].weight < list[j].weight && list[i].height < list[j].height)
					cnt++;
			}
			sb.append(cnt).append(" ");
		}
		
		System.out.print(sb.toString());

	}
}

class Person {
	int weight;
	int height;

	public Person(int w, int h) {
		this.weight = w;
		this.height = h;
	}
}