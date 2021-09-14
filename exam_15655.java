// 15655번 문제(N과 M(6))

import java.io.*;
import java.util.*;

public class exam_15655 {
	static int N;
	static int M;
	static int[] result;
	static int[] num;
	static boolean[] check;
	static BufferedWriter bw;
	
	public static void line(int count,int start) throws Exception {
		if(count == M) {
			for(int i=0;i<M;i++) {
				bw.write(result[i] + " ");
			}
			bw.write("\n");
			return;
		}
		for(int i=start;i<N;i++) {
			if(check[i] == false) {
				result[count] = num[i];
				check[i] = true;
				line(count+1,i+1);
				check[i] = false;
			}
		}	
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];
		num = new int[N];
		check = new boolean[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		line(0,0);
		bw.flush();
		bw.close();
	}
}
