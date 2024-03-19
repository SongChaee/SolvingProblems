import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Country> q = new PriorityQueue<>();
		int kg = 0, ks = 0, kb = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int idx = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			q.add(new Country(idx, g, s, b));
			if(idx == K) {
				kg = g;
				ks = s;
				kb = b;
			}
		}
		
		int cnt = 0;
		while(q.peek().idx != K) {
			Country c = q.poll();
			if(c.gold == kg && c.silver == ks && c.bronze == kb)
				cnt--;
			cnt++;
		}
		
		System.out.print(cnt + 1);
	}
}

class Country implements Comparable<Country>{
	int idx;
	int gold;
	int silver;
	int bronze;
	
	public Country(int idx, int g, int s, int b) {
		this.idx = idx;
		this.gold = g;
		this.silver = s;
		this.bronze = b;
	}
	
	@Override
	public int compareTo(Country c) {
		if(c.gold == gold) {
			if(c.silver == silver) {
				return c.bronze - bronze;
			}
			return c.silver - silver;
		}
		return c.gold - gold;
	}
}