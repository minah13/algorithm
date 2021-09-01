// 1037번 문제(약수)

import java.io.*;
import java.util.*;

public class exam_1037 {
	static int N;
	static int[] divisor;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		divisor = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i =0;i<N;i++) {
			divisor[i] = Integer.parseInt(st.nextToken());
			if(min > divisor[i])
				min = divisor[i];
			if(max < divisor[i])
				max = divisor[i];
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(min*max + "");
		bw.flush();
		bw.close();
	}
}
