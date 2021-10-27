//2225번 문제(합분해)
import java.io.*;
import java.util.*;

public class exam_2225 {
	public static void main(String[] args) throws Exception{
		int N;
		int K;
		int[][] count;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		count = new int[K+1][N+1];
		
		for(int i=0;i<=N;i++) {
			count[1][i] = 1;
		}
		
		for(int i=2;i<=K;i++) {
			int tmp = 1;
			count[i][0] = 1;
			for(int j=1;j<=N;j++) {
				tmp += count[i-1][j];
				tmp %= 1000000000;
				count[i][j] = tmp;
			}
		}
		
		System.out.print(count[K][N]);
		
	}
}
