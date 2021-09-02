// 17427 문제(약수의 합2)

import java.io.*;
import java.util.*;

public class exam_17427 {
	public static void main(String[] args) throws Exception{
		int n;
		long sum=0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for(int i =1;i<=n;i++) {
			sum += (i*(n/i));      // i가 1부터 n까지의 약수에 몇번 포함되는지 계산
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sum + "");
		bw.flush();
		bw.close();
	}
}
