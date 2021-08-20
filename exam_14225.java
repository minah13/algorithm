// 14225 문제(부분 수열의 합)

import java.io.*;
import java.util.*;

public class exam_14225 {
	static char[] num;
	static int N;
	static int[] S;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		int size=0;
		int i;
		for(i = 0;i<N;i++) {
			size += S[i];
		}
		num = new char[size+2];
		
		sum(0,0);
		for(i =0; i<size+2;i++) {
			if(num[i]!='o') {
				System.out.println(i);
				break;
			}
		}
		
		br.close();
	}
	
	public static void sum(int index,int s) {
		num[s] = 'o';
		if(index >= N)
			return;
		sum(index+1,s+S[index]);
		sum(index+1,s);
	}
}
