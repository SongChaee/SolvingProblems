import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[][] synergy;
	public static int sum = 0;
	public static int[] teamA, teamB;
	public static int gapmin = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 사람의 수, 시너지 정보 입력
		N = Integer.parseInt(br.readLine());
		synergy = new int[N][N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				synergy[i][j] = Integer.parseInt(st.nextToken());
				sum += synergy[i][j];
			}
		}
		
		// N명 중에서 N/2명을 고르는 조합을 구하고, 시너지 합의 최솟값을 연산하는 메서드 실행
		boolean[] person = new boolean[N];
		combi(person, 0, 0);
		
		System.out.print(gapmin);
	}
	
	public static void combi(boolean[] p, int index, int k) {
		// N/2 명의 사람을 다 골랐을 때 재귀 종료
		if(k == N/2) {
			// A팀으로 선택된 사람들의  번호를 teamA 배열에 저장
			teamA = new int[N/2];
			teamB = new int[N/2];
			int a = 0;
			int b = 0;
			for(int i = 0; i < N; i++) {
				if(p[i]) teamA[a++] = i;
				else teamB[b++] = i;
			}
			
			// A팀의 시너지 합 계산
			int synergyA = 0;
			for(int i = 0; i < N/2-1; i++) {
				for(int j = i + 1; j < N/2; j++) {
					synergyA += synergy[teamA[i]][teamA[j]];
					synergyA += synergy[teamA[j]][teamA[i]];
				}
			}
			
			// B팀의 시너지 합 계산
			int synergyB = 0;
			for(int i = 0; i < N/2-1; i++) {
				for(int j = i + 1; j < N/2; j++) {
					synergyB += synergy[teamB[i]][teamB[j]];
					synergyB += synergy[teamB[j]][teamB[i]];					
				}
			}
			
			// A, B 두 팀 간 시너지 합의 최솟값 계산
			gapmin = Math.min(gapmin, (int) Math.abs(synergyA - synergyB));
			
			return;
		}
		// 모든 사람에 대해서 다 탐색했을 때 재귀 종료
		if(index >= N) return;
		
		// 반복 조건
		p[index] = true;
		combi(p, index + 1, k + 1);
		
		p[index] = false;
		combi(p, index + 1, k);
	}
}