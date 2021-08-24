// 14500번 문제 테트로미노
// 다시 도전해보기!

import java.io.*;
import java.util.*;

public class exam_14500 {
	static int[][] paper;
	static int N;
	static int M;
	static boolean[][] check;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int max = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		paper = new int[N][M];
		check = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i =0;i<N;i++) {
			for(int j=0;j<M;j++) {
				tetromino(i,j,0,0);
				if(i+2<N) {
					int tmp = paper[i][j] + paper[i+1][j] + paper[i+2][j];
					if(j+1<M) {
						int tmp2 = tmp + paper[i+1][j+1];
						if(tmp2 > max)
							max = tmp2;
					}
					if(j-1>=0) {
						int tmp2 = tmp + paper[i+1][j-1];
						if(tmp2 > max)
							max = tmp2;
					}
				}
				if(j+2<M) {
					int tmp = paper[i][j] + paper[i][j+1] + paper[i][j+2];
					if(i+1<N) {
						int tmp2 = tmp + paper[i+1][j+1];
						if(tmp2 > max)
							max = tmp2;
					}
					if(i-1>=0) {
						int tmp2 = tmp + paper[i-1][j+1];
						if(tmp2 > max)
							max = tmp2;
					}
				}
			}
			
		}
		
		System.out.println(max);
	}
	
	public static void tetromino(int x, int y, int count, int sum) {
		if(count == 4) {
			if(max < sum) {
				max = sum;
			}
			return;
		}
		if(x <0 || x >= N || y < 0 || y >= M || check[x][y]) {
			return;
		}
		check[x][y] = true;
		for(int i =0;i<4;i++) {
			tetromino(x+dx[i],y+dy[i],count+1,sum+paper[x][y]);
		}
		check[x][y] = false;
	}
}
