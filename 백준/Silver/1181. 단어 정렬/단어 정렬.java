import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Word implements Comparable<Word>{
	String str;
	int len;
	
	public Word(String str) {
		this.str = str;
		this.len = str.length();
	}
	
	@Override
	public int compareTo(Word w) {
		if(len == w.len)
			return this.str.compareTo(w.str);
		return len - w.len;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Word[] list = new Word[N];
		for(int i = 0; i < N; i++)
			list[i] = new Word(br.readLine());
		Arrays.sort(list);
		
		StringBuilder sb = new StringBuilder();
		String tmp = list[0].str;
		sb.append(list[0].str).append("\n");
		for(int i = 1; i < N; i++) {
			if(!list[i].str.equals(tmp)) {
				sb.append(list[i].str).append("\n");
				tmp = list[i].str;
			}
		}
		
		System.out.print(sb.toString());
	}
}