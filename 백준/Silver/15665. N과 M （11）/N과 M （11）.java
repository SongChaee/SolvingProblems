import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N, seqLen;
	public static int[] given;
	public static boolean[] used;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		seqLen = Integer.parseInt(st.nextToken());
		
		given = new int[N];
		used = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
			given[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(given);
		
		int[] arr = new int[seqLen];
		seq(0, arr);
		
		System.out.print(sb.toString());
	}
	
	public static void seq(int idx, int[] arr) {
		if(idx == seqLen) {
			for(int i = 0; i < seqLen; i++)
				sb.append(arr[i]).append(" ");
			sb.append("\n");
			return;
		}
		
		int temp = 0;
		for(int i = 0; i < N; i++) {
			if(temp != given[i]) {
				arr[idx] = given[i];
				temp = given[i];
				seq(idx + 1, arr);
			}
		}
	}
}