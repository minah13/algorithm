//11052번 문제(카드 구매하기)

import java.io.*;
import java.util.*;

public class exam_11052 {
	static int[] max;
	
	public static int card(int[] P, int index) {
		if(max[index]!=0)
			return max[index];
		
		int p = index-1;
		int q = 1;
		int tmp=0;
		int a;
		int b;
		while(p>=q) {
			if(max[p] ==0)
				a = card(P,p);
			else
				a = max[p];
			
			if(max[q]==0)
				b = card(P,q);
			else
				b = max[q];
			
			if(tmp<a+b)
				tmp = a+b;
			p--;
			q++;
		}
		
		if(tmp<P[index])
			tmp = P[index];
		
		max[index] = tmp;
		
		return max[index];
	}
	
	public static void main(String args[]) throws Exception{
		int N;
		int[] P;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		P = new int[N+1];
		max = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		max[0] = 0;
		max[1] = P[1];
		
		
		int result = card(P,N);
		System.out.println(result);
	}
}
