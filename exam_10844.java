//10844번 문제(쉬운 계단 수)

import java.io.*;

public class exam_10844 {
	public static void main(String args[]) throws Exception{
		int N;
		long result = 0;
		long[][] num;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new long[N][10];
		
		
		for(int i=1;i<=9;i++)
			num[0][i] = 1;
		
		for(int i=2;i<=N;i++) {
			for(int j=0;j<=9;j++) {
				if(j==0) {
					num[i-1][j+1] = (num[i-1][j+1] + num[i-2][j])%1000000000;
				}else if(j==9) {
					num[i-1][j-1] = (num[i-1][j-1] + num[i-2][j])%1000000000;
				}else {
					num[i-1][j+1] = (num[i-1][j+1] + num[i-2][j])%1000000000;
					num[i-1][j-1] = (num[i-1][j-1] + num[i-2][j])%1000000000;
				}
			}
		}
		
		for(int i=0;i<=9;i++)
			result = (result + num[N-1][i])%1000000000;
		
		System.out.println(result);
	}
}
