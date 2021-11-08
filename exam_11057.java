//11057번 문제(오르막 수)
import java.io.*;
import java.util.*;

public class exam_11057 {
	public static void main(String[] args)throws Exception{
		int N;
		int[][] num;
		int answer=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N+1][10];
		
		for(int i=0;i<10;i++) {
			num[1][i] = 1;
		}
		
		for(int i=2;i<=N;i++) {
			for(int j=0;j<10;j++) {
				int tmp=0;
				for(int k=0;k<10;k++) {
					if(j<k)
						break;
					tmp += num[i-1][k];
					tmp %= 10007;
				}
				num[i][j] = tmp;
			}
		}
		
		for(int i=0;i<10;i++) {
			answer += num[N][i];
			answer %= 10007;
		}
		
		
		System.out.println(answer);
	}
}
