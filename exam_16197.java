// 16197번 문제 (두 동전)
// 브루트 포스

import java.io.*;
import java.util.*;

public class exam_16197 {
	static char[][] board;
	static int N;
	static int M;
	static int min = 11;
	static int[] x_dir = {-1,0,0,1};
	static int[] y_dir = {0,1,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		int x1=-1;
		int x2=-1;
		int y1=-1;
		int y2=-1;
		
		for(int i =0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<M;j++) {
				board[i][j] = tmp.charAt(j);
			}
		}
		
		for(int i =0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(board[i][j] == 'o') {
					if(x1==-1) {
						x1 = i;
						y1 = j;
					}else {
						x2 = i;
						y2 = j;
							
					}
				}
			}
		}
		
		for(int i =0;i<4;i++) {
			move(board, 1,x1,y1,x2,y2,i);
		}
		if(min >10) {
			System.out.println(-1);
		}
		else {
			System.out.println(min);
		}
		
	}
	
	public static void move(char[][] b, int count, int x1, int y1, int x2, int y2, int dir) {
		if(count>10) {
			return;
		}
		int x1_move = x1 + x_dir[dir];
		int x2_move = x2 + x_dir[dir];
		int y1_move = y1 + y_dir[dir];
		int y2_move = y2 + y_dir[dir];
		
		char[][] tmp = new char[N][M];
		for(int i =0;i<N;i++) {
			for(int j =0; j<M;j++) {
				tmp[i][j] = b[i][j];
			}
		}
		
		if(x1_move>=N || x1_move<0 || y1_move>=M || y1_move<0) {
			if(x2_move>=0 && x2_move<N && y2_move>=0 && y2_move<M) {
				if(min>count) {
					min = count;
				}
			}
			return;
		}
		if(x2_move>=N || x2_move<0 || y2_move>=M || y2_move<0) {
			if(x1_move>=0 && x1_move<N && y1_move>=0 && y1_move<M) {
				if(min>count) {
					min = count;
				}
			}
			return;
		}
		
		if(tmp[x1_move][y1_move] == '.' || tmp[x1_move][y1_move] == 'o') {
			tmp[x1][y1] = '.';
			
		}
		else if(tmp[x1_move][y1_move] == '#') {
			x1_move = x1;
			y1_move = y1;
		}
		if(tmp[x2_move][y2_move] == '.' || tmp[x2_move][y2_move] == 'o') {
			tmp[x2][y2] = '.';
			
		}
		else if(tmp[x2_move][y2_move] == '#') {
			x2_move = x2;
			y2_move = y2;
		}
		
		tmp[x1_move][y1_move] = 'o';
		tmp[x2_move][y2_move] = 'o';
		
		for(int i=0;i<4;i++) {
			move(tmp,count+1,x1_move,y1_move,x2_move,y2_move,i);
		}
		
	}
}
