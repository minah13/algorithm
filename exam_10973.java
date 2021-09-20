//10973번 문제(이전 문제)

import java.io.*;
import java.util.*;

public class exam_10973 {
	
	public static boolean before(int N, int[] num) {
		int k=-1;
		for(int i=N-1;i>0;i--) {
			if(num[i]<num[i-1]) {
				k = i;
				break;
			}
		}
		
		if(k==-1) {
			return false;
		}
		
		
		for(int i=N-1;i>k-1;i--) {
			if(num[k-1]>num[i]) {
				int tmp = num[i];
				num[i] = num[k-1];
				num[k-1] = tmp;
				break;
			}
		}
		
		int o = N-1;
		while(o>k) {
			int tmp = num[o];
			num[o] = num[k];
			num[k] = tmp;
			o--;
			k++;
		}
		
		return true;
	}
	
	public static void main(String args[]) throws Exception{
		int N;
		int[] num;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean b = before(N,num);
		
		if(b == false) {
			System.out.println(-1);
		}else {
			for(int i=0;i<N;i++) {
				System.out.print(num[i] + " ");
			}
		}
		
	}
}
