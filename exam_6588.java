// 6588번 문제(골드바흐의 추측)

import java.io.*;

public class exam_6588 {
	static int[] num = new int[1000000];
	static boolean[] check = new boolean[1000001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int c=0;
		check[0] = true;
		check[1] = true;
		for(int i=2;i<=1000;i++) {
			if(check[i] == true)
				continue;
			num[c++] = i;
			for(int j=2;j*i<=1000000;j++) {
				check[i*j] = true;
			}
		}
		
		int n;
		while((n = Integer.parseInt(br.readLine())) != 0) {
			
			int min = goldbach(n);
			if(min == -1) {
				bw.write("Goldbach's conjecture is wrong.\n");
			}
			else {
				int max = n-min;
				bw.write(n + " = " + min + " + " + max + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
	
	public static int goldbach(int n) {
		for(int i=1;num[i]*2<=n;i++) {
			if(check[n-num[i]] == false)
				return num[i];
		}
		return -1;
	}
}
