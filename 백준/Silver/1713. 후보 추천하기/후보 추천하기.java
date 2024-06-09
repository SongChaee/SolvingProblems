import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static Student[] photo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		photo = new Student[N];
		for (int i = 0; i < N; i++) {
			photo[i] = new Student();
		}

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int date = 0;
		for (int i = 0; i < K; i++) {
			int to = Integer.parseInt(st.nextToken());

			int exist = isExist(to);
			if (exist != -1) {
				photo[exist].vote++;
			} else {
				int emptyIndex = getEmptyIndex();
				if (emptyIndex != -1) {
					photo[emptyIndex] = new Student(to, 1, date);
				} else {
					Arrays.sort(photo);
					photo[0] = new Student(to, 1, date);
				}
			}

			date++;
		}

		Arrays.sort(photo, (a, b) -> Integer.compare(a.idx, b.idx));
		for (Student s : photo) {
			if (s.idx != 0) {
				System.out.print(s.idx + " ");
			}
		}
	}

	public static int isExist(int idx) {
		for (int i = 0; i < N; i++) {
			if (photo[i].idx == idx)
				return i;
		}
		return -1;
	}

	public static int getEmptyIndex() {
		for (int i = 0; i < N; i++) {
			if (photo[i].idx == 0)
				return i;
		}
		return -1;
	}
}

class Student implements Comparable<Student> {
	int idx;
	int vote;
	int date;

	public Student() {
		this.idx = 0;
		this.vote = 0;
		this.date = 0;
	}

	public Student(int i, int v, int d) {
		this.idx = i;
		this.vote = v;
		this.date = d;
	}

	@Override
	public int compareTo(Student s) {
		if (vote == s.vote)
			return date - s.date;
		return vote - s.vote;
	}
}
