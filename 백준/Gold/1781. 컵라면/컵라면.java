import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		Work[] list = new Work[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int d = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			list[i] = new Work(d, n);
		}

		Arrays.sort(list, new Comparator<Work>() {
			@Override
			public int compare(Work w1, Work w2) {
				return w2.deadline - w1.deadline;
			}
		});

		PriorityQueue<Work> q = new PriorityQueue<>();
		int idx = 0;
		int sum = 0;

		for (int i = 200000; i >= 1; i--) {
			while (idx < list.length && list[idx].deadline == i)
				q.add(list[idx++]);

			if (q.isEmpty())
				continue;

			sum += q.poll().noodle;
		}

		System.out.println(sum);
	}
}

class Work implements Comparable<Work> {
	int deadline;
	int noodle;

	public Work(int d, int n) {
		this.deadline = d;
		this.noodle = n;
	}

	@Override
	public int compareTo(Work w) {
		if (w.noodle == noodle)
			return deadline - w.deadline;
		return w.noodle - noodle;
	}
}
