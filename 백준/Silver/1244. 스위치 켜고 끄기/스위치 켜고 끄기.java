import java.util.Scanner;

public class Main {
	static int Nswitch = 0;
	static boolean[] sw = new boolean[1001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Nswitch = sc.nextInt();
		sw = new boolean[Nswitch + 1];
		for(int i = 1; i <= Nswitch; i++) {
			int status = sc.nextInt();
			if(status == 1)
				sw[i] = true;
		}
		
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			int gender = sc.nextInt();
			int idx = sc.nextInt();
			if(gender == 1)
				man(idx);
			else
				woman(idx);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= Nswitch; i++){
			if(i > 20 && i % 20 == 1)
				sb.append("\n");
			if(sw[i] == true)
				sb.append("1 ");
			else
				sb.append("0 ");
		}
		System.out.print(sb.toString());
	}
	
	static void man(int idx) {
		int temp = idx;
		while(temp <= Nswitch) {
			sw[temp] = !sw[temp];
			temp++;
			while(temp % idx != 0)
				temp++;
		}
	}
	
	static void woman(int idx) {
		int i = 1;
		sw[idx] = !sw[idx];
		while(idx - i > 0 && idx + i <= Nswitch && sw[idx-i] == sw[idx+i]) {
			sw[idx-i] = !sw[idx-i];
			sw[idx+i] = !sw[idx+i];
			i++;
		}
	}
}