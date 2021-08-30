//2580 문제(스도쿠)

import java.io.*;
import java.util.*;

public class exam_2580 {
	static int[][] board = new int[9][9];
	static int count = 0;
	static int[][] result = new int[9][9];
	static int[][] empty = new int[81][2];
	static boolean[][] row = new boolean[9][10];
	static boolean[][] column = new boolean[9][10];
	static boolean[][] square = new boolean[9][10];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tmp = 0;
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				row[i][board[i][j]] = true;
				column[j][board[i][j]] = true;
				square[i/3*3 + j/3][board[i][j]] = true;
				
				if(board[i][j] ==0) {
					empty[tmp][0] = i;
					empty[tmp++][1] = j;
					count++;	
				}
			}
		}
		
		prob(0,0);
		
	}
	
	public static void prob(int empty_c, int index) throws Exception{
		int i;
		int j;
		int ro = empty[index][0];
		int co = empty[index][1];
		
		if(empty_c == count) {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for(i = 0;i<9;i++) {
				for(j=0;j<9;j++) {
					bw.write(board[i][j] + " ");
				}
				bw.write("\n");
			}
			bw.flush();
			bw.close();
			
			count = 0;
			return;
		}
		
		for(i = 1; i<=9;i++) {
			if(row[ro][i] == false && column[co][i] == false && square[ro/3*3 + co/3][i] == false) {
				board[ro][co] = i;
				row[ro][i] = true;
				column[co][i] = true;
				square[ro/3*3 + co/3][i] = true;
				prob(empty_c+1,index+1);
				if(count == 0)
					return;
				row[ro][i] = false;
				column[co][i] = false;
				square[ro/3*3 + co/3][i] = false;
			}
		}
		
	}

}
