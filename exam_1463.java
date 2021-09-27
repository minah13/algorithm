//1463번 문제(1로 만들기)

import java.io.*;

public class exam_1463 {
	static int min=Integer.MAX_VALUE;
	public static void cal(int x,int count) {

		if(min<count)
			return ;
		if(x==1) {
			if(min>count)
				min = count;
			return;
		}
				
		if(x%3==0) {
			cal(x/3,count+1);
		}
		if(x%2==0) {
			cal(x/2,count+1);
		}
		cal(x-1,count+1);
		
		
	}
	public static void main(String args[]) throws Exception{
		int N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		cal(N,0);
		System.out.println(min);
	}
}
