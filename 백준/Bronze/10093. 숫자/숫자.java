import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
        StringBuilder sb = new StringBuilder();
        
        if(B > A){
            sb.append(B - A - 1).append("\n");
            for(int i = A + 1; i < B; i++)
                sb.append(i).append(" ");
            System.out.println(sb.toString());
        } else if(A > B){
            sb.append(A - B - 1).append("\n");
            for(int i = B + 1; i < A; i++)
                sb.append(i).append(" ");
            System.out.println(sb.toString());
        } else {
            System.out.println(0);
        }
	}
}