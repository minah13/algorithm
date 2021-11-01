//1149번 문제(RGB거리)
import java.io.*;
import java.util.*;

public class exam_1149 {
	public static void main(String[] args) throws Exception{
		int N;
		int[][] cost;
		int[][] sum;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		sum = new int[N][3];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		
		sum[0][0] = cost[0][0];
		sum[0][1] = cost[0][1];
		sum[0][2] = cost[0][2];
		
		for(int i=1;i<N;i++) {
			for(int j=0;j<3;j++) {
				int min = Integer.MAX_VALUE;
				for(int k=0;k<3;k++) {
					if(j==k)
						continue;
					if(min>sum[i-1][k]+cost[i][j]) {
						min = sum[i-1][k] + cost[i][j];
					}
				}
				sum[i][j] = min;
			}
		}
		
		int tmp = sum[N-1][0];
		for(int i=1;i<3;i++) {
			if(tmp>sum[N-1][i])
				tmp = sum[N-1][i];
		}
		
		System.out.println(tmp);
	}
}
