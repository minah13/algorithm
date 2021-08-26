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
				if(board[i][j] == 'o') {
					if(x1==-1) {
						x1 = i;
						y1 = j;
					}else {
						x2 = i;
						y2 = j;
							
					}
					board[i][j] = '.';
				}
			}
		}
		
		move(0,x1,y1,x2,y2);
		
		if(min >10) {
			System.out.println(-1);
		}
		else {
			System.out.println(min);
		}
		
	}
	
	public static void move(int count, int x1, int y1, int x2, int y2) {
		if(count>10) {
			return ;
		}
		boolean x1y1 = false;
		boolean x2y2 = false;
		if(x1>=N || x1<0 || y1>=M || y1<0) x1y1=true;
		if(x2>=N || x2<0 || y2>=M || y2<0) x2y2=true;
		
		if(x1y1 && x2y2) return;
		if(x1y1 || x2y2) {
			if(min>count)
				min = count;
			return;
		}
		
		
		for(int i =0;i<4;i++) {
			int x1_move = x1 + x_dir[i];
			int x2_move = x2 + x_dir[i];
			int y1_move = y1 + y_dir[i];
			int y2_move = y2 + y_dir[i];
			
			if(x1_move>=0 && x1_move<N && y1_move>=0 && y1_move<M && board[x1_move][y1_move] == '#') {
				x1_move = x1;
				y1_move = y1;
			}
			
			if(x2_move>=0 && x2_move<N && y2_move>=0 && y2_move<M && board[x2_move][y2_move] == '#') {
				x2_move = x2;
				y2_move = y2;
			}
			
			move(count+1,x1_move,y1_move, x2_move, y2_move);
		}
		
		
	}
}
