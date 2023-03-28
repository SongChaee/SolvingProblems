import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int M;
    static int Mtemp;
	static char[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = N * 2;
        arr = new char[N][M];

        
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                arr[i][j] = ' ';

        int size = N / 3;

        recur(N - 1, M/2 - 1, size);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++)
                sb.append(arr[i][j]);
            sb.append("\n");
        }
        System.out.print(sb.toString());

    }

    public static void recur(int x, int y, int size) {
        if(size == 1) {
            triangle(x, y);
            return;
        }
        
        recur(x - (size/2 * 3), y, size / 2);
        recur(x, y - (size/2 * 3), size / 2);
        recur(x, y + (size/2 * 3), size / 2);
    }

    public static void triangle(int x, int y) {
        arr[x-2][y] = '*';
        arr[x-1][y-1] = '*'; arr[x-1][y+1] = '*';
        for(int i = 0; i < 3; i++) {
            arr[x][y+i] = '*';
            arr[x][y-i] = '*';
        }
    }
}