// 문제 9663번(N-Queen)

import java.io.*;

public class exam_9663 {
	static int N;
	static int count=0;
	static boolean[][] board;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		board = new boolean[N][N];
		
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
				row(r+1);
				board[r][i] = false;
			}
		}
	}
	
	public static boolean check(int r, int c) {
		for(int i =0;i<N;i++) {
			if(board[i][c] == true) {
				return false;
			}
		}
		
		int lu_x = r-1;
		int lu_y = c-1;
		while(lu_x>=0 && lu_y>=0) {
			if(board[lu_x][lu_y] == true)
				return false;
			lu_x = lu_x -1;
			lu_y = lu_y -1;
		}
		
		int ru_x = r-1;
		int ru_y = c+1;
		while(ru_x>=0 && ru_y<N) {
			if(board[ru_x][ru_y] == true)
				return false;
			ru_x = ru_x -1;
			ru_y = ru_y +1;
		}
		
		int ld_x = r+1;
		int ld_y = c-1;
		while(ld_x<N && ld_y>=0) {
			if(board[ld_x][ld_y] == true)
				return false;
			ld_x = ld_x +1;
			ld_y = ld_y -1;
		}
		
		int rd_x = r+1;
		int rd_y = c+1;
		while(rd_x<N && rd_y<N) {
			if(board[rd_x][rd_y] == true)
				return false;
			rd_x = rd_x +1;
			rd_y = rd_y +1;
		}
		return true;
	}
	
}
