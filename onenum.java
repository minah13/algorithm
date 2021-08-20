// 1065 문제

import java.io.*;

public class onenum {
	static int n;
	static int result=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		if(n<100) {
			result = n;
		}
		else {
			result = 99;
			for(int i=100;i<=n;i++) {
				int a = i/100;
				int b = i/10%10;
				int c = i%10;
				
				int d1 = a-b;
				int d2 = b-c;
				if(d1 == d2) {
					result++;
				}
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(result + "");
		bw.flush();
		bw.close();
		
	}
}
