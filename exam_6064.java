// 6064번 문제(카잉 달력)
import java.io.*;
import java.util.*;

public class exam_6064 {
	static int M;
	static int N;
	
	public static int kaing(int x, int y) {
		boolean[] check = new boolean[40000];
		int sub;
		int max_value;
		int a = x;
		int b = y;
		
		if(x>y) {
			sub = x-y;
			max_value = 1;
		}else {
			sub = y-x;
			max_value = 2;
		}
		while(true) {
			if(a == b)
				return a;
			int max;
			if(a>b) {
				max = a;
				b += N;
				if(max_value==1 && sub == a-b)
					break;
			}else{
				max = b;
				a += M;
				if(max_value == 2 && sub == b-a)
					break;
			}
			
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws Exception{
		int T;
		int x;
		int y;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			int result = kaing(x,y);
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
		
	}
}
