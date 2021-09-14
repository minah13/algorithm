//18290번 문제(NM과 K(1))

import java.io.*;
import java.util.*;

public class exam_18290 {
	static int N;
	static int M;
	static int K;
	static int[][] board;
	static int max = -40001;
	
	public static void choose(int index, int count, int sum, boolean[][] check) {
		if(count==K) {
			if(sum> max)
				max = sum;
			return;
		}
			
		if(index>=N*M)
			return ;
		
		for(int i=index;i<N*M;i++) {
			
			int x = i/M;
			int y = i%M;
			boolean flag = false;
			
			if(x-1>=0) {
				if(check[x-1][y])
					flag=true;
			}
			if(y-1>=0) {
				if(check[x][y-1])
					flag = true;
			}
			
			if(flag==true)
				continue;
			
			check[x][y] = true;
			choose(i+1,count+1,sum + board[x][y], check);
			check[x][y] = false;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[][] check = new boolean[N][M];
		choose(0,0,0,check);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(max + "");
		bw.flush();
		bw.close();
	}
}
