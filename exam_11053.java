//11053번 문제(가장 긴 증가하는 부분 수열)

import java.io.*;
import java.util.*;

public class exam_11053 {
	
	public static void main(String args[]) throws Exception{
		int N;
		int[] A;
		int result;
		int[] length;
		int[][] num;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[N];
		length = new int[N];
		num = new int[N][N];
		
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			int k=i;
			int l=1;
			for(int j=i-1;j>=0;j--) {
				if(A[k]>A[j]) {
					l +=1;
					k = j;
				}
			}
			length[i] = l;
			
			for(int j=0;j<i;j++) {
				if(length[j]+1>length[i] && A[i]>A[j])
					length[i] = length[j]+1;
			}
		}
		
		result = length[N-1];
		
		
		for(int i=0;i<N-1;i++) 
		{ 
			if(result<length[i]) 
				result =length[i]; 
		}
		
		System.out.println(result);
		
	}
}
