//1978번 문제(소수 찾기)

import java.io.*;
import java.util.*;

public class exam_1978 {
	public static void main(String[] args) throws Exception{
		int N;
		int[] num;
		int count = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			if(num[i] <= 1)
				continue;
			int j;
			for(j =2;j*j<=num[i];j++) {
				if(num[i]%j == 0)
					break;
			}
			if(j*j>num[i])
				count++;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(count + "");
		bw.flush();
		bw.close();
	}
}
