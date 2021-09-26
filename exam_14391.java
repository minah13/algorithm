//14391번 문제(종이 조각)

import java.io.*;
import java.util.*;

public class exam_14391 {
	static int N;
	static int M;
	static int[][] board;
	static int max=0;
	static boolean[][] check;
	public static void cut(int index,int sum) {
		if(index==N*M) {
			if(sum>max) {
				max = sum;
			}
			return ;
		}
		
		int x;
		int y;
		int tmp=0;
		x = index/M;
		y = index%M;
		
		if(check[x][y] == true) {
			cut(index+1,sum);
			return ;
		}
		
		for(int i=x;i<N;i++) {
			tmp = tmp*10;
			tmp = tmp + board[i][y];
			if(check[i][y] == false) {
				for(int j=x;j<=i;j++)
					check[j][y] = true;
				cut(index+1,sum+tmp);
				for(int j=x;j<=i;j++)
					check[j][y] = false;
			}else {
				break;
			}
		}
		
	
		tmp = 0;
		for(int i=y;i<M;i++) {
			tmp = tmp*10;
			tmp = tmp + board[x][i];
			if(check[x][i] == false) {
				if(i!=y) {
					for(int j=y;j<=i;j++)
						check[x][j] = true;
					cut(index+1,sum+tmp);
					for(int j=y;j<=i;j++)
						check[x][j] = false;
				}
			}else {
				break;
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		check = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<M;j++) {
				board[i][j] = Character.getNumericValue(tmp.charAt(j));
			}
		}
		
		cut(0,0);
		
		System.out.println(max);
		
	}
}
