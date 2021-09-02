// 2609번 문제(최대공약수와 최소공배수)
import java.io.*;
import java.util.*;

public class exam_2609 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x;
		int y;
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int g = gcd(x,y);
		int l = lcm(x,y);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(g + "\n");
		bw.write(l + "");
		bw.flush();
		bw.close();
	}
	
	static int gcd(int x, int y) {
		int b;
		int a;
		if(x<y) {
			b = x;
			a = y;
		}else {
			b = y;
			a = x;
		}
		
		while(b != 0) {
			int tmp = b;
			b = a%b;
			a = tmp;
		}
		return a;
	}
	
	static int lcm(int x, int y) {
		int g = gcd(x,y);
		return x*y/g;
	}
}
