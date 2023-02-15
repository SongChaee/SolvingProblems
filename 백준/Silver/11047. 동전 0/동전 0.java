import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coinValue = new int[N];
		int[] coinNum = new int[N];
		for(int i = 0; i < N; i++)
			coinValue[i] = Integer.parseInt(br.readLine());
		
		System.out.println(cal(coinValue, coinNum, K, N-1));
		
	}
	
	static int cal(int[] value, int[] num, int K, int i) {
		if(K == 0 && i >= 0) {
			int sum = 0;
			for(int n : num)
				sum += n;
			return sum;
		}
		
		while(K/value[i] == 0)
			i--;
		num[i] = K/value[i];
		K = K % value[i];
		
		if(i-1 < 0) {
			int sum = 0;
			for(int n : num)
				sum += n;
			return sum;
		}
		return cal(value, num, K, i-1);
	}
}