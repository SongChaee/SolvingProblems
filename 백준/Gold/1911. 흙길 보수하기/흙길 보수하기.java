import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		PriorityQueue<Pond> q = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			q.add(new Pond(s, e));
		}

		int pos = 0;
		int ans = 0;

		while (!q.isEmpty()) {
			Pond now = q.poll();

			if (now.end < pos)
				continue;

			if (pos < now.start)
				pos = now.start;

			int remain = (now.end - pos) % L;
			ans += (now.end - pos) / L;
			pos = now.end;

			if (remain != 0) {
				ans++;
				pos += L - remain;
			}
		}

		System.out.println(ans);
	}
}

class Pond implements Comparable<Pond> {
	int start;
	int end;

	public Pond(int s, int e) {
		this.start = s;
		this.end = e;
	}

	@Override
	public int compareTo(Pond p) {
		return start - p.start;
	}
}