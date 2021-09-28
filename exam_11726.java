// 11726번 문제(2*n 타일링)

import java.io.*;

public class exam_11726 {
	static int[] count;
	
	public static int tile(int n) {
		int a;
		int b;
		if(n<=2) 
			return count[n];
		if(count[n-1]!=0)
			a = count[n-1];
		else
			a = tile(n-1);
		
		if(count[n-2]!=0)
			b = count[n-2];
		else
			b = tile(n-2);
		
		count[n] = (a+b)%10007;
		return count[n];
	}
	public static void main(String[] args) throws Exception{
		int n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		count = new int[n+1];
		count[1] = 1;
		if(n>1) {
			count[2] = 2;
		}
		int result = tile(n);
		System.out.println(result);
	}
}
