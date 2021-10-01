//15990번 문제(1,2,3 더하기 5)

import java.io.*;

public class exam_15990 {
	static long[][] m;
	
	public static void main(String args[]) throws Exception{
		int T;
		int n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		m = new long[100001][4];

		m[1][1] = 1;
		m[2][2] = 1;
		m[3][1] = 1;
		m[3][2] = 1;
		m[3][3] = 1;
		
		for(int i=4;i<=100000;i++) {
			m[i][1] = (m[i-1][2] + m[i-1][3])%1000000009;
			m[i][2] = (m[i-2][1] + m[i-2][3])%1000000009;
			m[i][3] = (m[i-3][1] + m[i-3][2])%1000000009;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=1;i<=T;i++) {
			n = Integer.parseInt(br.readLine());
			long result = (m[n][1] + m[n][2])%1000000009;
			result = (result + m[n][3])%1000000009;
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
		
	}
}
