import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Score implements Comparable<Score> {
	int num;
	int score;

	public Score(int num, int score) {
		this.num = num;
		this.score = score;
	}

	@Override
	public int compareTo(Score s) {
		return s.score - score;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Score[] quest = new Score[8];
		for (int i = 1; i <= 8; i++) {
			int score = Integer.parseInt(br.readLine());
			quest[i - 1] = new Score(i, score);
		}
		Arrays.sort(quest);

		int sum = 0;
		int[] questN = new int[5];
		for (int i = 0; i < 5; i++) {
			sum += quest[i].score;
			questN[i] = quest[i].num;
		}
		Arrays.sort(questN);

		StringBuilder sb = new StringBuilder();
		sb.append(sum).append("\n");
		for (int i = 0; i < 5; i++)
			sb.append(questN[i]).append(" ");

		System.out.print(sb.toString());

	}
}