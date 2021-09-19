//10972번 문제(다음 순열)

import java.io.*;
import java.util.*;

public class exam_10972 {
	
	public static boolean next(int N, int[] num) {
		int a = num[N-1];
		int tmp;
		int max=0;
		int i;
		for(i=N-2;i>=0;i--) {
			if(a>num[i]) {
				max =i;
				break;
			}
			a = num[i];
		}
		
		if(i<0) {
			return false;
		}
		
		if(max==N-2) {
			tmp = num[N-2];
			num[N-2] = num[N-1];
			num[N-1] = tmp;
			return true;
		}
		
		a = num[max];
		for(i=N-1;i>=max+1;i--) {
			if(a<num[i]) {
				tmp = num[i];
				num[i] = num[max];
				num[max] = tmp;
				int[] tmp2 = new int[N];
				int k=0;
				for(int j=N-1;j>=max+1;j--) {
					tmp2[k++] = num[j];
				}
				for(int j=0;j<k;j++) {
					num[max+1+j] = tmp2[j];
				}
				break;
			}
			
		}
		
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		int N;
		int[] num;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean t = next(N,num);
		if(!t)
			System.out.println(-1);
		else {
			for(int i =0;i<N;i++) {
				System.out.print(num[i]  + " ");
			}
		}
	}
}
