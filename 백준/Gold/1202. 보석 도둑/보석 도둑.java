import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int JewelN = Integer.parseInt(st.nextToken());
		int BagN = Integer.parseInt(st.nextToken());
		
		Jewel[] jewels = new Jewel[JewelN];
		for(int n = 0; n < JewelN; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			jewels[n] = new Jewel(w, v);
		}
		Arrays.sort(jewels);
		
		int[] bags = new int[BagN];
		for(int n = 0; n < BagN; n++) {
			bags[n] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags);
		
		long value = 0;
		PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
		int j = 0;
		for(int b = 0; b < BagN; b++) {
			while(j < JewelN && jewels[j].weight <= bags[b]) {
				q.add(jewels[j].value);
				j++;
			}
			
			if(!q.isEmpty()) {
				value += q.poll();
			}
		}
		
		System.out.print(value);
	}

}

class Jewel implements Comparable<Jewel>{
	int weight;
	int value;
	
	public Jewel(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}

	@Override
	public int compareTo(Jewel j) {
		if(weight == j.weight)
			return j.value - value;
		return weight - j.weight;
	}
}