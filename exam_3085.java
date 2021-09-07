// 3085번 문제(사탕 게임)

import java.io.*;

public class exam_3085 {
	
	static char[][] board;
	static int n;
	static int max = 0;
	
	public static void compare_row(int r) {
		int count = 1;
		char tmp = board[r][0];
		for(int m=1;m<n;m++) {
			if(tmp == board[r][m]) {
				count++;
			}else {
				if(max< count)
					max = count;
				count=1;
				tmp = board[r][m];
			}
		}
		
		if(max< count)
			max = count;
		
	}
	
	public static void compare_col(int c) {
		int count = 1;
		char tmp = board[0][c];
		for(int m=1;m<n;m++) {
			if(tmp == board[m][c]) {
				count++;
			}else {
				if(max< count)
					max = count;
				count=1;
				tmp = board[m][c];
			}
		}
		
		if(max< count)
			max = count;
		
	}
	
	public static void main(String[] args) throws Exception{
		
		int[] move_x = {0,1};
		int[] move_y = {1,0};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new char[n][n];
		
		// 배열 board에 데이터 채워넣기
		for(int i=0;i<n;i++) {
			String tmp = br.readLine();
			for(int j=0;j<n;j++) {
				board[i][j] = tmp.charAt(j);
			}
		}
		
		for(int i =0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<2;k++) {
					int x=i+move_x[k];
					int y=j+move_y[k];

					if(x<n && y<n) {
						char tmp = board[i][j];
						board[i][j] = board[x][y];
						board[x][y] = tmp;
						
						if(move_x[k]==0) {
							//첫번째 비교
							compare_col(j);
							
							// 두번째 비교
							compare_col(y);
							
							compare_row(x);
							
						}else {
							//첫번째 비교
							compare_row(i);
							
							// 두번째 비교
							compare_row(x);
							
							compare_col(y);
						}
						
						tmp = board[i][j];
						board[i][j] = board[x][y];
						board[x][y] = tmp;
					}
				}
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(max + "");
		bw.flush();
		bw.close();
	}
	
}
