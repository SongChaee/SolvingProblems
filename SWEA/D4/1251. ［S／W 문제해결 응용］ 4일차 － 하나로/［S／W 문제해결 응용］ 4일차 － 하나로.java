import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	static int[] p;
	static double[][] loca;
	static double[][] dist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int V = sc.nextInt();
			
			loca = new double[V][2];
			for(int i = 0; i < V; i++)
				loca[i][0] = sc.nextDouble();
			for(int i = 0; i < V; i++)
				loca[i][1] = sc.nextDouble();
			
			double tax = sc.nextDouble();
			
			int E = V * (V - 1) / 2;
			int index = 0;
			dist = new double[E][3];
			for(int i = 0; i < V; i++) {
				for(int j = i + 1; j < V; j++) {
					double price = tax * (double) (Math.pow(loca[j][0] - loca[i][0], 2) + Math.pow(loca[j][1] - loca[i][1], 2));
					dist[index][0] = i;
					dist[index][1] = j;
					dist[index][2] = price;
					index++;
				}
			}
			
			Arrays.sort(dist, new Comparator<double[]>() {
				public int compare(double[] o1, double[] o2) {
					return Double.compare(o1[2], o2[2]);
				}
			});
			
			p = new int[V];
			for(int i = 0; i < V; i++)
				p[i] = i;
			
			double sum = 0;
			int pick = 0;
			
			for(int i = 0; i < E; i++) {
				int px = findset((int) dist[i][0]);
				int py = findset((int) dist[i][1]);
				
				if(px != py) {
					union(px, py);
					sum += dist[i][2];
					pick++;
				}
				
				if(pick == (V - 1)) break;
			}
			
			System.out.println("#" + tc + " " + Math.round(sum));
		}
	}
	
	public static int findset(int x) {
		if(x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}

    public static void union(int x, int y) {
        p[y] = x;
    }
}