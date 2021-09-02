// 17425번 문제(약수의 합)

import java.io.*;

public class exam_17425 {
	public static void main(String[] args) throws Exception{
		int T;
		int N;
		long[] result = new long[1000001];   // 각 수의 약수의 합을 저장
		long[] sum = new long[1000001];     // 1의 약수 ~ 각 index의 약수 합
				
		for(int i=1;i<=1000;i++) {
			for(int j=i;j*i<=1000000;j++) {      // 곱이 1000000가 될 때까지
				result[i*j] += i;
				if(i!= j)
					result[i*j] +=j;
			}
		}
		for(int i=1;i<=1000000;i++) {
			sum[i] = sum[i-1] + result[i];      // 1의 약수~ i의 약수까지 더하는 과정
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
				
		for(int i =0;i<T;i++) {
			N = Integer.parseInt(br.readLine());
			bw.write(sum[N] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}
}
