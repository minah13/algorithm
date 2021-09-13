// 15652번 문제(N과 M(4))

import java.io.*;
import java.util.*;

public class exam_15652 {
	static int N;
	static int M;
	static int[] result;
	static BufferedWriter bw;
	
	public static void line(int count,int start) throws Exception {
		if(count == M) {
			for(int i=0;i<M;i++) {
				bw.write(result[i] + " ");
			}
			bw.write("\n");
			return;
		}
		for(int i=start;i<=N;i++) {
			result[count] = i;
			line(count+1,i);
		}	
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		line(0,1);
		bw.flush();
		bw.close();
	}
}
