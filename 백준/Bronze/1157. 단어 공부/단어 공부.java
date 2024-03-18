import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		char[] str = new char[input.length()];
		int[] cnt = new int[26];

		for (int i = 0; i < input.length(); i++) {
			str[i] = input.charAt(i);

			if (str[i] >= 'A' && str[i] <= 'Z')
				cnt[str[i] - 'A']++;
			else if (str[i] >= 'a' && str[i] <= 'z')
				cnt[str[i] - 'a']++;
		}

		PriorityQueue<Char> q = new PriorityQueue<>();
		for (int i = 0; i < 26; i++)
			q.add(new Char((char) (i + 'A'), cnt[i]));

		Char result = q.poll();

		if (q.peek().cnt == result.cnt)
			System.out.println("?");
		else
			System.out.println(result.c);
	}
}

class Char implements Comparable<Char> {
	char c;
	int cnt;

	public Char(char c, int cnt) {
		this.c = c;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Char c) {
		return c.cnt - cnt;
	}
}
