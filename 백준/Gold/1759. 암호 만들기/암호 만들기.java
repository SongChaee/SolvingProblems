import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int L, C;
	public static char[] alphabet;
	public static boolean[] isVowel = new boolean[26];
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		isVowel['a' - 'a'] = true;
		isVowel['e' - 'a'] = true;
		isVowel['i' - 'a'] = true;
		isVowel['o' - 'a'] = true;
		isVowel['u' - 'a'] = true;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		alphabet = new char[C];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++)
			alphabet[i] = st.nextToken().charAt(0);
		Arrays.sort(alphabet);
	
		make(0, "", 0);
		
		System.out.print(sb.toString());
	}

	public static void make(int idx, String str, int cnt) {
        if (str.length() == L) {
            if (cnt >= 1 && L - cnt >= 2) {
                sb.append(str).append("\n");
            }
            return;
        }

        if (idx >= C)
            return;

        // idx번째 문자를 암호에 포함시킬 때
        make(idx + 1, str + alphabet[idx], isVowel[alphabet[idx] - 'a'] ? cnt + 1 : cnt);

        // idx번째 문자를 암호에 포함시키지 않을 때
        make(idx + 1, str, cnt);
    }
}
