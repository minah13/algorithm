//11727번 문제(2*n 타일링 2)

import java.io.*;

public class exam_11727 {
	static int[] count;
	
	public static int tile(int n) {
		
		int a;
		int b;
		
		if(n<=2)
			return count[n];
		if(count[n] != 0)
			return count[n];
		
		a = tile(n-1);
		b = tile(n-2);
		count[n] = (a+2*b)%10007;
		
		return count[n];
	}
	
	public static void main(String args[]) throws Exception{
		int n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		count = new int[n+1];
		count[1] = 1;
		if(n>=2)
			count[2] = 3;
		
		int result = tile(n);
		
		System.out.println(result);
	}
}
