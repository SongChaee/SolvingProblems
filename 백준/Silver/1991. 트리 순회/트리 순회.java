import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	// 노드의 개수
	public static int N;
	// 트리 정보
	public static ArrayList<Node> tree = new ArrayList<>();
	// 답 출력 시 사용
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		// 노드의 개수, 트리 정보 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			char node = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			tree.add(new Node(node, left, right));
		}
		
		// 전위, 중위, 후위 순회 수행
		preorder(0);
		sb.append("\n");
		inorder(0);
		sb.append("\n");
		postorder(0);
		
		// 결과 출력
		System.out.print(sb.toString());
	}
	
	// 전위순회
	public static void preorder(int n) {
		char node = tree.get(n).node;
		char left = tree.get(n).left;
		char right = tree.get(n).right;
		
		// V
		sb.append(node);
		// L
		if(left != '.') {
			int idx = 0;
			for(int i = 0; i < N; i++)
				if(tree.get(i).node == left) {
					idx = i;
					break;
				}
			preorder(idx);
		}
		// R
		if(right != '.') {
			int idx = 0;
			for(int i = 0; i < N; i++)
				if(tree.get(i).node == right) {
					idx = i;
					break;
				}
			preorder(idx);
		}
	}
	
	// 중위순회
	public static void inorder(int n) {
		char node = tree.get(n).node;
		char left = tree.get(n).left;
		char right = tree.get(n).right;
		
		// L
		if(left != '.') {
			int idx = 0;
			for(int i = 0; i < N; i++)
				if(tree.get(i).node == left) {
					idx = i;
					break;
				}
			inorder(idx);
		}
		// V
		sb.append(node);
		
		// R
		if(right != '.') {
			int idx = 0;
			for(int i = 0; i < N; i++)
				if(tree.get(i).node == right) {
					idx = i;
					break;
				}
			inorder(idx);
		}
	}
	
	// 후위순회
	public static void postorder(int n) {
		char node = tree.get(n).node;
		char left = tree.get(n).left;
		char right = tree.get(n).right;
		
		// L
		if(left != '.') {
			int idx = 0;
			for(int i = 0; i < N; i++)
				if(tree.get(i).node == left) {
					idx = i;
					break;
				}
			postorder(idx);
		}
		// R
		if(right != '.') {
			int idx = 0;
			for(int i = 0; i < N; i++)
				if(tree.get(i).node == right) {
					idx = i;
					break;
				}
			postorder(idx);
		}
		// V
		sb.append(node);
	}
}

class Node{
	char node, left, right;
	public Node(char node, char left, char right) {
		this.node = node;
		this.left = left;
		this.right = right;
	}
}