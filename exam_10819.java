//10819번 문제 (차이를 최대로)

import java.io.*;
import java.util.*;

public class exam_10819 {
	static int max = 0;
	
	public static boolean order(int N, int[] a) {
		int sum = 0;
		for(int i=0;i<N-1;i++) {
			int tmp;
			tmp = a[i] -a[i+1];
			if(tmp<0)
				tmp = -tmp;
			sum = sum + tmp;
		}
		if(max<sum)
			max = sum;
		
		int k=-1;
		for(int i = N-1; i>0;i--) {
			if(a[i]>a[i-1]) {
				k=i;
				break;
			}
		}
		
		if(k==-1)
			return false;
		
		for(int i=N-1;i>=0;i--) {
			if(a[k-1]<a[i]) {
				int tmp;
				tmp = a[k-1];
				a[k-1] = a[i];
				a[i] = tmp;
				break;
			}
		}
		
		int o = N-1;
		while(o>k) {
			int tmp;
			tmp = a[o];
			a[o] = a[k];
			a[k] = tmp;
			o--;
			k++;
		}
		
		return true;
	}
	public static void main(String args[]) throws Exception{
		int N;
		int[] a;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
		
		while(order(N,a)) {
			
		}
		System.out.println(max);
	}
}
