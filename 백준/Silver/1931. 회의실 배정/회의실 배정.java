import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static ArrayList<Meeting> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		// 회의 정보를 리스트에 저장
		StringTokenizer st;
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Meeting(start, end));
		}
		// 회의 정보 중 종료 시간을 기준으로 오름차순 정렬
		Collections.sort(list);
		
		// 리스트에 저장된 모든 회의 정보에 대해 수행
		int cnt = 0;
		int time = 0;
		for(int i = 0; i < num; i++) {
			if(time > list.get(i).start)
				continue;
			cnt++;
			time = list.get(i).end;
		}
		
		System.out.print(cnt);
	}
}

class Meeting implements Comparable<Meeting>{
	int start, end;
	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	// 회의 정보 중 종료 시간을 기준으로 오름차순 정렬
	// 만약 종료 시간이 동일하다면 시작 시간 순으로 오름차순 정렬
	@Override
	public int compareTo(Meeting m) {
		if(end == m.end)
			return start - m.start;
		return end - m.end;
	}
}
