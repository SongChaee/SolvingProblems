import java.util.Scanner;

public class Solution {
	static char[][] map = new char[20][20];
	static int H, W, x, y;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String[] str = sc.nextLine().split(" ");
			H = Integer.parseInt(str[0]);
			W = Integer.parseInt(str[1]);
			map = new char[H][W];

			for(int h =  0; h < H; h++) {
				map[h] = sc.nextLine().toCharArray();
				for(int w = 0; w < W; w++) {
					if(map[h][w] == '^' || map[h][w] == 'v' || map[h][w] == '<' || map[h][w] == '>') {
						x = h; y = w;
					}
				}
			}
			
			int N = Integer.parseInt(sc.nextLine());
			char[] comm = new char[N];
			comm = sc.nextLine().toCharArray();
			
			for(int i = 0; i < N; i++) {
				if(comm[i] == 'U') up();
				else if(comm[i] == 'D') down();
				else if(comm[i] == 'L') left();
				else if(comm[i] == 'R') right();
				else shoot();
			}
			
			System.out.printf("#%d ", tc);
			for(int h = 0; h < H; h++) {
				for(int w = 0; w < W; w++)
					System.out.print(map[h][w]);
				System.out.println();
			}
		}
	}
	
	static void up() {
		map[x][y] = '^';
		if(x - 1 >= 0 && map[x-1][y] == '.') {
			map[x][y] = '.';
			x = x - 1;
			map[x][y] = '^';
		}
	}
	
	static void down() {
		map[x][y] = 'v';
		if(x + 1 < H && map[x+1][y] == '.') {
			map[x][y] = '.';
			x = x + 1;
			map[x][y] = 'v';
		}
	}
	
	static void left() {
		map[x][y] = '<';
		if(y - 1 >= 0 && map[x][y-1] == '.') {
			map[x][y] = '.';
			y = y - 1;
			map[x][y] = '<';
		}
	}
	
	static void right() {
		map[x][y] = '>';
		if(y + 1 < W && map[x][y+1] == '.') {
			map[x][y] = '.';
			y = y + 1;
			map[x][y] = '>';
		}
	}
	
	static void shoot() {
		int carx = x;
		int cary = y;
		if(map[x][y] == '^')
			while(x >= 0) {
				if(map[x][y] == '*') {
					map[x][y] = '.';
					break;
				}else if(map[x][y] == '#')
					break;
				x--;
			}
		else if(map[x][y] == 'v')
			while(x < H) {
				if(map[x][y] == '*') {
					map[x][y] = '.';
					break;
				}else if(map[x][y] == '#')
					break;
				x++;
			}
		else if(map[x][y] == '<')
			while(y >= 0) {
				if(map[x][y] == '*') {
					map[x][y] = '.';
					break;
				}else if(map[x][y] == '#')
					break;
				y--;
			}
		else {
			while(y < W) {
				if(map[x][y] == '*') {
					map[x][y] = '.';
					break;
				}else if(map[x][y] == '#')
					break;
				y++;
			}
		}
		
		x = carx;
		y = cary;
	}
}