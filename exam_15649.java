// 15649번 문제(N과 M(1))

import java.io.*;
import java.util.*;

public class exam_15649 {
	static boolean[] check;
	static int N;
	static int M;
	
	public static void line(int count,int[] result) {
		if(count == M) {
			for(int i=0;i<M;i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=N;i++) {
			if(check[i] != true) {
				result[count] = i;
				check[i] = true;
				line(count+1,result);
				check[i] = false;
			}	
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		check = new boolean[N+1];
		int[] result = new int[M];
		line(0,result);
	}
}
