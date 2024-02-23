import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long target = Long.parseLong(br.readLine());

		int numA = Integer.parseInt(br.readLine());
		int[] a = new int[numA];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numA; i++)
			a[i] = Integer.parseInt(st.nextToken());

		int numB = Integer.parseInt(br.readLine());
		int[] b = new int[numB];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numB; i++)
			b[i] = Integer.parseInt(st.nextToken());

		// 가능한 모든 부 배열의 합 저장
		int lenA = numA * (numA + 1) / 2;
		long[] sumA = new long[lenA];
		int idx = 0;
		for (int i = 0; i < numA; i++) {
			long sum = 0;
			for (int j = i; j < numA; j++) {
				sum += a[j];
				sumA[idx++] = sum;
			}
		}
		Arrays.sort(sumA);

		int lenB = numB * (numB + 1) / 2;
		long[] sumB = new long[lenB];
		idx = 0;
		for (int i = 0; i < numB; i++) {
			long sum = 0;
			for (int j = i; j < numB; j++) {
				sum += b[j];
				sumB[idx++] = sum;
			}
		}
		Arrays.sort(sumB);

		// 투포인터 사용
		int idxA = 0;
		int idxB = lenB - 1;
		long cnt = 0;
		while (idxA < lenA && idxB >= 0) {
			long valueA = sumA[idxA];
			long valueB = sumB[idxB];
			long sum = valueA + valueB;

			// target과 합이 같을 때,
			// 해당 원소가 부배열에서 몇개 존재하는지 카운트
			if (sum == target) {
				long cntA = 0;
				long cntB = 0;
				while (idxA < lenA && sumA[idxA] == valueA) {
					idxA++;
					cntA++;
				}
				while (idxB >= 0 && sumB[idxB] == valueB) {
					idxB--;
					cntB++;
				}
				
				cnt += cntA * cntB;
			}
			
			// 합이 target보다 클 때, B 부배열 포인터 이동
			if(sum > target)
				idxB--;
			
			// 합이 target보다 작을 때, A 부배열 포인터 이동
			if(sum < target)
				idxA++;
		}
		
		System.out.print(cnt);
	}
}