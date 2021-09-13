//15650번 문제(N과 M(2))

import java.io.*;
import java.util.*;

public class exam_15650 {
	
	static int n;
	static int m;
	
	public static void line(int count, int[] result, int start) {
		if(count==m) {
			for(int i=0;i<m;i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<=n;i++) {
			result[count] = i;
			line(count+1,result,i+1);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[] result = new int[m];
		line(0,result,1);
	}
}
