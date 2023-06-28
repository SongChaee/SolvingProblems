import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		// 출근한 사람들을 담는 해시
		HashMap<String, String> map = new HashMap<>();
		
		// 출입기록 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			String employ = st.nextToken();
			String status = st.nextToken();
			if(status.equals("enter"))
				map.put(employ, status);
			else if(status.equals("leave"))
				if(map.containsKey(employ))
					map.remove(employ);
		}
		
		// 현재 회사에 있는 사람 "역순" 출력
		List<String> working = new ArrayList<>(map.keySet());
		Collections.sort(working);
		// Collections.reverse(working);
		for(int i = working.size() - 1; i >= 0; i--)
			System.out.println(working.get(i));
	}
}