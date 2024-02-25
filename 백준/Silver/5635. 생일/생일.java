import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {
	String name;
	int day, month, year;

	public Student(String name, int day, int month, int year) {
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	public int compareTo(Student s) {
		if (year == s.year) {
			if (month == s.month)
				return day - s.day;
			return month - s.month;
		}
		return year - s.year;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Student[] list = new Student[N];

		StringTokenizer st;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());

			list[n] = new Student(name, day, month, year);
		}

		Arrays.sort(list);

		System.out.println(list[N - 1].name);
		System.out.println(list[0].name);

	}
}