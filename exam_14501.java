//14501번 문제(퇴사)

import java.io.*;
import java.util.*;

public class exam_14501 {
	static int max=0;
	public static void consult(int[] T, int[] P, int N,int start,int sum) {
		if(start>=N) {
			if(sum>max)
				max=sum;
			return;
		}
		
		for(int i=start;i<N;i++) {
			int t = T[i];
			t += i;
			if(t>N) {
				consult(T,P,N,N,sum);
			}else {
				consult(T,P,N,t,sum+P[i]);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		int N;
		int[] T;
		int[] P;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		T = new int[N];
		P = new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		consult(T,P,N,0,0);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(max + "");
		bw.flush();
		bw.close();
		
	}
}
