//2193번 문제(이친수)

import java.io.*;

public class exam_2193 {
	public static void main(String args[]) throws Exception{
		int N;
		long[][] num;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new long[N+1][2];
		
		num[1][0] = 0;
		num[1][1] = 1;
		
		for(int i=2;i<=N;i++) {
			num[i][0] = num[i-1][0] + num[i-1][1];
			num[i][1] = num[i-1][0];
		}
		
		long result = num[N][0] + num[N][1];
		System.out.println(result);
	}
}
