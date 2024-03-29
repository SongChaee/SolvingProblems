import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		char[][] map = new char[101][101];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++)
				map[i][j] = tmp.charAt(j);
			map[i][N] = map[N][i] = 'X';
		}

		int row = 0;
		int col = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (map[i][j] == '.' && map[i][j + 1] == '.' && map[i][j + 2] == 'X')
					row++;
				if (map[j][i] == '.' && map[j + 1][i] == '.' && map[j + 2][i] == 'X')
					col++;
			}
		}

		System.out.print(row + " " + col);

	}
}
