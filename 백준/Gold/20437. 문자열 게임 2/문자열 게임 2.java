import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static ArrayList<ArrayList<Integer>> input;
	static int K;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			input = new ArrayList<>();
			for(int i = 0; i < 26; i++)
				input.add(new ArrayList<>());
			
			String str = br.readLine();
			K = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				input.get(c - 'a').add(i);
			}
			
			find();
		}
		
		System.out.print(sb.toString());
	}
	
	public static void find() {
		boolean[] upto = new boolean[26];
		boolean flag = false;
		
		for(int i = 0; i < 26; i++) {
			if(input.get(i).size() >= K) {
				upto[i] = true;
				flag = true;
			}
		}
		
		// 주어진 문자열에서 K개 이상인 문자가 없는 경우
		if(!flag) {
			sb.append("-1\n");
			return;
		}
		
		// 특정 문자를 K개 포함하는 가장 짧은 문자열의 길이
		ArrayList<Str> list = new ArrayList<>();
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < 26; i++) {
			if(upto[i]) {
				for(int j = 0; j <= input.get(i).size() - K; j++) {
					list.add(new Str(input.get(i).get(j), input.get(i).get(j + K - 1)));
				}
			}
		}
		Collections.sort(list);
		sb.append(list.get(0).end - list.get(0).start + 1).append(" ");
		
		// 특정 문자 K개를 포함하고 첫번째와 마지막 글자가 특정 문자로 같은 문자열의 최대 길이
		sb.append(list.get(list.size() - 1).end - list.get(list.size() - 1).start + 1).append("\n");
	}
}

class Str implements Comparable<Str>{
	int start;
	int end;
	
	public Str(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Str s) {
		if(end - start == s.end - s.start)
			return start - s.start;
		return ((end - start) - (s.end - s.start));
	}
}