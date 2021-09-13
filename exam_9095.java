// 9095번 문제(1,2,3 더하기)

import java.io.*;

public class exam_9095 {
	
	public static int onetwo(int x) {
		int method=0;
		if(x<0)
			return 0;
		if(x==0)
			return 1;
		for(int i=1;i<=3;i++) {
			
			method += onetwo(x-i);
		}
		return method;
	}
	
	public static void main(String[] args) throws Exception{
		int T;
		int n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			n = Integer.parseInt(br.readLine());
			int count = onetwo(n);
			System.out.println(count);
		}
	}
}
