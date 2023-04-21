import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		boolean[] check = new boolean[input.length];
		
		List<char[]> alphabet = new ArrayList<>();
		alphabet.add(new char[] {'c', '='});
		alphabet.add(new char[] {'c', '-'});
		alphabet.add(new char[] {'d', 'z', '='});
		alphabet.add(new char[] {'d', '-'});
		alphabet.add(new char[] {'l', 'j'});
		alphabet.add(new char[] {'n', 'j'});
		alphabet.add(new char[] {'s', '='});
		alphabet.add(new char[] {'z', '='});
		
		int num = 0;
		
		for(int i = 0; i < input.length; i++) {
			if(!check[i]) {
				for(int j = 0; j < alphabet.size(); j++) {
					if(i < input.length-1 && input[i] == alphabet.get(j)[0]) {
						int samecnt = 1;
						for(int k = 1; k < alphabet.get(j).length; k++)
							if(i+k < input.length && input[i+k] == alphabet.get(j)[k])
								samecnt++;
						if(samecnt == alphabet.get(j).length) {
							num++;
							for(int l = 0; l < alphabet.get(j).length; l++)
								check[i+l] = true;
							break;
						}
					}
				}
			}
			if(!check[i])
				num++;
		}
		
		System.out.print(num);
	}
}