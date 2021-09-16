//14889번 문제(스타트와 링크)

import java.io.*;
import java.util.*;

public class exam_14889 {
	
	static int N;
	static int[][] exp;
	static int min = Integer.MAX_VALUE;
	
	public static void div_team(int count, int[] start, int[] link, int s, int l) {
		if(count==N) {
			int start_sum=0;
			int link_sum=0;
			for(int i=0;i<s;i++) {
				for(int j=0; j<s;j++) {
					start_sum += exp[start[i]][start[j]];
				}
			}
			
			for(int i=0;i<l;i++) {
				for(int j=0; j<l;j++) {
					link_sum += exp[link[i]][link[j]];
				}
			}
			
			int sub = start_sum-link_sum;
			if(sub<0)
				sub = -sub;
			
			if(min>sub)
				min = sub;
			return;
		}
		
		if(s<N/2){
			start[s] = count;
			div_team(count+1,start,link,s+1,l);
		}
		if(l<N/2) {
			link[l] = count;
			div_team(count+1,start,link,s,l+1);
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		exp = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				exp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] start = new int[N/2];
		int[] link = new int[N/2];
		
		div_team(0,start,link,0,0);
		
		System.out.println(min);
		
	}
}
