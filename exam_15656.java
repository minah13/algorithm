// 15656번 문제(N과 M(7))

import java.io.*;
import java.util.*;

public class exam_15656 {
	static int N;
	static int M;
	static int[] result;
	static int[] num;
	static BufferedWriter bw;
	
	public static void line(int count) throws Exception {
		if(count == M) {
			for(int i=0;i<M;i++) {
				bw.write(result[i] + " ");
			}
			bw.write("\n");
			return;
		}
		for(int i=0;i<N;i++) {
			result[count] = num[i];
			line(count+1);
		}	
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		line(0);
		bw.flush();
		bw.close();
	}
}
