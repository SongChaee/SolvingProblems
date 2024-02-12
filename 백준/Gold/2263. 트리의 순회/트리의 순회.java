import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] in, post, pre;
	static int preIdx;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		in = new int[N];
		post = new int[N];
		pre = new int[N];
		preIdx = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int n = 0; n < N; n++)
			in[n] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int n = 0; n < N; n++)
			post[n] = Integer.parseInt(st.nextToken());
		
		getPre(0, N - 1, 0, N - 1);
		
		StringBuilder sb = new StringBuilder();
		for(int n : pre)
			sb.append(n).append(" ");
		
		System.out.print(sb.toString());
	}
	
	public static void getPre(int is, int ie, int ps, int pe) {
		if(is <= ie && ps <= pe) {
			int root = post[pe];
			pre[preIdx] = root;
			
			int idx = is;
			for(int i = is; i <= ie; i++) {
				if(in[i] == root) {
					idx = i;
					break;
				}
			}
				
			preIdx++;
			
			getPre(is, idx - 1, ps, ps + idx - is - 1);
			getPre(idx + 1, ie, ps + idx - is, pe - 1);
		}
	}
}
