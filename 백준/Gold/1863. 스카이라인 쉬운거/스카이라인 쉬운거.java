import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		ArrayList<Building> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int location = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			list.add(new Building(location, h));
		}
		
		Collections.sort(list);
		
		Stack<Integer> s = new Stack<>();
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int h = list.get(i).height;

			if (s.isEmpty() || s.peek() < h)
				s.push(h);

			if (s.peek() > h) {
				while (!s.isEmpty() && s.peek() > h) {
					s.pop();
					ans++;
				}
				if (!s.isEmpty() && s.peek() < h)
					s.push(h);
				if (s.isEmpty())
					s.push(h);
			}
		}

		while (!s.isEmpty()) {
			if (s.pop() > 0)
				ans++;
		}

		System.out.print(ans);
	}
}

class Building implements Comparable<Building>{
	int location;
	int height;
	
	public Building(int l, int h) {
		this.location = l;
		this.height = h;
	}
	
	@Override
	public int compareTo(Building b) {
		return location - b.location;
	}
}
