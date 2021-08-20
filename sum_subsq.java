// 1182 문제

import java.io.*;
import java.util.*;

public class sum_subsq {
	static int sum;
	static int N;
	static int[] num;
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		sum = Integer.parseInt(st.nextToken());
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		count=0;
		add(0,0,0);
		System.out.println(count);
	}
	
	public static void add(int result, int choice,int flag) {
		if(flag != 0 && result == sum) {
			count++;
		}
		if(choice >= N ) {
			return ;
		}
		
		add(result+num[choice],choice+1,1);
		add(result,choice+1,0);
	}
}
