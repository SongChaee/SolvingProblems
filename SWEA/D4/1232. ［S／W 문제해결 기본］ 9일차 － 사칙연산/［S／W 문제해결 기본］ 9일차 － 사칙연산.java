import java.util.Scanner;

class Node{
    String value;
    int left;
    int right;
    Node(String value){
        this.value = value;
    }
}

public class Solution {
	static Node[] tree = new Node[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            sc.nextLine();
            tree = new Node[N+1];
            for(int n = 0; n < N; n++) {
                String[] input = sc.nextLine().split(" ");
                int num = Integer.parseInt(input[0]);
                if(input[1].equals("+")) {
                	tree[num] = new Node(input[1]);
                    tree[num].left = Integer.parseInt(input[2]);
                    tree[num].right = Integer.parseInt(input[3]);
                }else if(input[1].equals("-")) {
                	tree[num] = new Node(input[1]);
                    tree[num].left = Integer.parseInt(input[2]);
                    tree[num].right = Integer.parseInt(input[3]);
                }else if(input[1].equals("*")) {
                	tree[num] = new Node(input[1]);
                    tree[num].left = Integer.parseInt(input[2]);
                    tree[num].right = Integer.parseInt(input[3]);
                }else if(input[1].equals("/")) {
                	tree[num] = new Node(input[1]);
                    tree[num].left = Integer.parseInt(input[2]);
                    tree[num].right = Integer.parseInt(input[3]);
                } else {
                	tree[num] = new Node(input[1]);
                }
            }
            
            cal(1);
            System.out.printf("#%d %s\n", tc, tree[1].value);
        }
    }

    static void cal(int i) {
        if(i < tree.length && tree[i].left != 0 && tree[i].right != 0) {
            if(checkleft(tree[i]))
            	cal(tree[i].left);
            if(checkright(tree[i]))
            	cal(tree[i].right);
            if(!checkleft(tree[i]) && !checkright(tree[i])) {
            	if(tree[i].value.equals("+"))
            		tree[i].value = (Integer.parseInt(tree[tree[i].left].value) + Integer.parseInt(tree[tree[i].right].value)) + "";
            	else if(tree[i].value.equals("-"))
            		tree[i].value = (Integer.parseInt(tree[tree[i].left].value) - Integer.parseInt(tree[tree[i].right].value)) + "";
            	else if(tree[i].value.equals("*"))
            		tree[i].value = (Integer.parseInt(tree[tree[i].left].value) * Integer.parseInt(tree[tree[i].right].value)) + "";
            	else if(tree[i].value.equals("/"))
            		tree[i].value = (Integer.parseInt(tree[tree[i].left].value) / Integer.parseInt(tree[tree[i].right].value)) + "";
            }
        }
    }
    
    static boolean checkleft(Node n) {
    	return tree[n.left].value.equals("+") || tree[n.left].value.equals("-") || tree[n.left].value.equals("*") || tree[n.left].value.equals("/");
    }
    
    static boolean checkright(Node n) {
    	return tree[n.right].value.equals("+") || tree[n.right].value.equals("-") || tree[n.right].value.equals("*") || tree[n.right].value.equals("/");
    }
}