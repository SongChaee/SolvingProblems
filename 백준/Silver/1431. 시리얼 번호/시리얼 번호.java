import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Guitar> q = new PriorityQueue<>();
		for(int i = 0; i < N; i++)
			q.add(new Guitar(br.readLine()));
		
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty())
			sb.append(q.poll().serial).append("\n");
		System.out.print(sb.toString());
		
	}
}
class Guitar implements Comparable<Guitar>{
	String serial;
	int len, sum;
	
	public Guitar(String serial) {
		this.serial = serial;
		this.len = serial.length();
		
		int s = 0;
		for(int i = 0; i < serial.length(); i++)
			if(serial.charAt(i) >= '0' && serial.charAt(i) <= '9')
				s += serial.charAt(i) - '0';
		this.sum = s;
	}
	
	@Override
	public int compareTo(Guitar g) {
		if(len == g.len) {
			if(sum == g.sum) {
				return (this.serial.compareTo(g.serial));
			}
			return sum - g.sum;
		}
		return len - g.len;
	}
}