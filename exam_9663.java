// 문제 9663번(N-Queen)

import java.io.*;

public class exam_9663 {
	static int N;
	static int count=0;
	static boolean[][] board;
	static boolean[] check_col;
	static boolean[] check_dig;
	static boolean[] check_dig2;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		board = new boolean[N][N];
		
		check_col = new boolean[N];
		check_dig = new boolean[N+N];
		check_dig2 = new boolean[N+N];
		row(0);
		System.out.println(count);
		
	}
	
	
	public static void row(int r) {
		if(r == N) {
			count++;
			return;
		}
		for(int i =0;i<N;i++) {
			if(check(r,i)) {
				board[r][i] = true;
				check_col[i] = true;
				check_dig[r+i] = true;
				check_dig2[N-1-i+r] = true;
				row(r+1);
				board[r][i] = false;
				check_col[i] =false;
				check_dig[r+i] = false;
				check_dig2[N-1-i+r] = false;
				
			}
		}
	}
	
	public static boolean check(int r, int c) {
		if(check_col[c] == true)
			return false;
		if(check_dig[r+c] == true)
			return false;
		if(check_dig2[N-1-c+r] == true)
			return false;
		return true;
	}
	
}
