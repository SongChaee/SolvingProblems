import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[] seat = new char[N];
		seat = br.readLine().toCharArray();
		
		int cupholder = 1;
		boolean coupleseat = false;
		for(int i = 0; i < N; i++) {
			if(seat[i] == 'S')
				cupholder++;
			else {
				if(coupleseat) {
					coupleseat = false;
					cupholder++;
				}
				else coupleseat = true;
			}
		}
		
		if(cupholder > N)
			System.out.print(N);
		else
			System.out.print(cupholder);
	}
}