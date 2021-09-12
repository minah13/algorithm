// 6064번 문제(카잉 달력)
import java.io.*;
import java.util.*;

public class exam_6064 {
	
	public static int kaing(int x, int y,int M, int N) {	
		
		boolean[] check = new boolean[N];
		int k = x;
		
		while(true) {
			if(k%N ==y)
				break;
			if(check[k%N])
				return -1;
			check[k%N] = true;
			k += M;
		}
		
		return k;
	}
	
	public static void main(String[] args) throws Exception{
		int T;
		int x;
		int y;
		int M;
		int N;
		int result;
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
			
			
			if(M>N) {
				if(N == y)
					y = 0;
				result = kaing(x,y,M,N);
			}else {
				if(M == x)
					x = 0;
				result = kaing(y,x,N,M);
			}
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
		
	}
}
