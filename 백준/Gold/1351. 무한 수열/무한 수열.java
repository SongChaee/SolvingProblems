import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static HashMap<Long, Long> map = new HashMap<>();
	static Long N, P, Q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		
		System.out.print(recur(N));
	}
	
	public static Long recur(long n) {
		if(n == 0)
			return (long) 1;
		
		if(map.containsKey(n))
			return map.get(n);
		
		map.put(n, (long) (recur(n/P) + recur(n/Q)));
		
		return map.get(n);
	}
}