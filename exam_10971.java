//10971번 문제(외판원 순회2) + 시작 위치를 고정!

import java.io.*;
import java.util.*;

public class Main {
	static long minW = Long.MAX_VALUE;
	
	public static void travel(int N, int[][] W, int index,int count,int w, boolean[] check,int start) {
		if(count == N-1) {
			if(W[index][start] == 0)
				return ;
			int tmp = w;
			tmp += W[index][start];
			if(minW>tmp)
				minW = tmp;
			return ;
		}
		
		for(int i=0;i<N;i++) {
			if(i!=index && check[i]==false && W[index][i] != 0) {
				check[index] = true;
				travel(N,W,i,count+1,w+W[index][i],check,start);
				check[index] = false;
			}
		}
	}
	
	public static void main(String args[]) throws Exception{
		int N;
		int[][] W;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[] check = new boolean[N];
		travel(N,W,0,0,0,check,0);
		
		//for(int j=0;j<N;j++) {
		//	boolean[] check = new boolean[N];
		//	travel(N,W,j,0,0,check,j);
		//}
		
		System.out.println(minW);
	}
}
