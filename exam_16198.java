// 16198번 문제(에너지 모으기)

import java.io.*;
import java.util.*;

public class exam_16198 {
	static int N;
	static int[] W;
	static int max;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N;i++) {
			W[i] = Integer.parseInt(st.nextToken());
		}
		
		energy(W,0,0);
		System.out.println(max);
		
		
	}
	
	public static void energy(int[] weight, int sum, int count) {
		if(count== N-2) {
			if(max<sum) {
				max = sum;
			}
			return;
		}
		int size = weight.length;
		for(int i =1;i<size-1;i++) {
			int[] tmp;
			tmp = new int[size-1];
			int k=0;
			for(int j =0;j<size;j++) {
				if(j!=i) {
					tmp[k++] = weight[j];
				}
			}
			energy(tmp,sum+weight[i-1]*weight[i+1],count+1);
		}
	}
}
