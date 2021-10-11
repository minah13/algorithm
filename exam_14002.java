//14002번 문제(가장 긴 증가하는 부분 수열4)

import java.io.*;
import java.util.*;

public class exam_14002 {
	public static void main(String[] args) throws Exception{
		int N;
		int[] A;
		int[] result;
		int len;
		int index;
		int[][] answer;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		result = new int[N];
		answer = new int[N][N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		result[0] = 1;
		answer[0][0] = 0;
		
		for(int i=1;i<N;i++) {
			int k=i;
			int l=1;
			int j;
			index = -1;
			answer[i][l-1] = i;
			for(j=i-1;j>=0;j--) {
				if(A[j]<A[k]) {
					k=j;
					l++;
					answer[i][l-1] = k;
				}
			}                  
			result[i] = l;
			
			for(j=0;j<i;j++) {
				if(A[j]<A[i] && result[j] +1 > result[i]) {
					result[i] = result[j]+1;
					index=j;
				}
			}
			
			if(index!=-1) {
				answer[i][0] = i;
				for(int x=0;x<result[index];x++) {
					answer[i][x+1] = answer[index][x];
				}
			}
		}
		
		len = result[0];
		index = 0;
		
		for(int i=1;i<N;i++) {
			if(len<result[i]) {
				len = result[i];
				index=i;
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(len + "\n");
		
		for(int i=len-1;i>=0;i--) {
			bw.write(A[answer[index][i]] + " ");
		}
		
		bw.flush();
		bw.close();
	}
}
