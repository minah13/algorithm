// 1929번 문제(소수 구하기)

import java.io.*;
import java.util.*;

public class exam_1929 {
	public static void main(String[] args) throws Exception{
		int min;
		int max;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		min = Integer.parseInt(st.nextToken());
		max = Integer.parseInt(st.nextToken());
		
		if(min == 1)
			min = 2;
		int[] result = new int[max];
		int count=0;
		boolean[] num = new boolean[max+1];
		
		for(int i=2;i<=max;) {
			result[count++] = i;
			for(int j=1;j*i<=max;j++) {
				num[i*j] = true;
			}
			while(i<=max && num[i]!=false)
				i++;
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i =0;i<count;i++) {
			if(result[i]>=min) {
				bw.write(result[i] + "\n");
			}
		}
		bw.flush();
		bw.close();
		
	}
}
