import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		TreeMap<Integer, Integer> map;
		for(int tc = 0; tc < T; tc++) {
			map = new TreeMap<>();
			
			int N = Integer.parseInt(br.readLine());
			for(int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				String comm = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				// 트리맵에 숫자를 key로 해서 삽입
				// 트리맵에 없다면 1을, 있다면 1 더한 값을 value로 삽입
				if(comm.equals("I"))
					map.put(num, map.getOrDefault(num, 0) + 1);
				
				// 숫자 삭제
				// 이때 트리맵에 있는 숫자가 없다면 continue
				else if(map.size() == 0)
					continue;
				else {
					int key = num == 1 ? map.lastKey() : map.firstKey();
					int value = map.get(key);
					if(value == 1)
						map.remove(key);
					else
						map.put(key, value - 1);
				}
			}
			
			if(map.size() == 0)
				sb.append("EMPTY\n");
			else
				sb.append(map.lastKey() + " " + map.firstKey() + "\n");
		}
		System.out.print(sb.toString());
	}
}