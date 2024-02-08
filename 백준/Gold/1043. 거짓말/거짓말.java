import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N: 사람의 수
		// M: 파티의 수
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 진실을 아는 사람
		boolean[] known = new boolean[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		int knownN = Integer.parseInt(st.nextToken());
		if(knownN != 0) {
			for(int i = 0; i < knownN; i++) {
				int idx = Integer.parseInt(st.nextToken());
				known[idx] = true;
			}
		}
		
		// n번인 사람이 m번 파티 참가 여부 저장
		ArrayList<ArrayList<Integer>> party = new ArrayList<>();
		ArrayList<ArrayList<Integer>> participant = new ArrayList<>();
		for(int m = 0; m < M; m++)
			party.add(new ArrayList<>());			
		for(int n = 0; n <= N; n++)
			participant.add(new ArrayList<>());
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			for(int i = 0; i < num; i++) {
				int n = Integer.parseInt(st.nextToken());
				party.get(m).add(n);
				participant.get(n).add(m);
			}
		}
		
		// 과장된 이야기를 할 수 있는 파티 여부
		if(knownN == 0) {
			System.out.print(M);
			return;
		}
		
		boolean[] notSpeak = new boolean[M];
		boolean[] visit = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();
		for(int n = 1; n <= N; n++) {
			if(known[n]) {
				for(int m : participant.get(n)) {
					q.add(m);
					notSpeak[m] = true;
					visit[n] = true;
				}
				
				while(!q.isEmpty()) {
					int partyIdx = q.poll();
					
					for(int idx : party.get(partyIdx)) {
						if(!visit[idx]) {
							for(int pIdx : participant.get(idx)) {
								q.add(pIdx);
								notSpeak[pIdx] = true;
							}
							visit[idx] = true;
						}
					}
				}
			}
		}
		
		int ans = 0;
		for(int m = 0; m < M; m++)
			if(!notSpeak[m])
				ans++;
		System.out.print(ans);
	}
}