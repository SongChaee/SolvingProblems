import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		// 입력: N개의 층
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 트리 그리기
		for(int i=1; i<=N; i++) {
			// 앞 공백 출력
			for(int front_blank=0; front_blank<N-i; front_blank++)
				System.out.print(" ");
			
			// 1층
			if(i==1) System.out.println("*");
			// 2층 ~ N-1층
			else if(1<i && i<N) System.out.println(tree_layer(i));
			// N층
			else {
				for(int j=0; j<N*2-1; j++)
					System.out.print("*");
			}
		}
	}
	
	// 별 사이 공백이 있는 층, *과 사이 공백을 문자열로 생성
	public static String tree_layer(int r) {
		String mid_blank = "";
		for(int i=0; i<r*2-3; i++)
			mid_blank += " ";
		String layer = "*" + mid_blank + "*";
		return layer;
	}
}