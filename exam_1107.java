// 1107번 문제(리모컨)

import java.io.*;
import java.util.*;

public class exam_1107 {
	static int N;
	static int M;
	static boolean[] button = new boolean[10];
	
	public static int up(int min) {
		int count;
		int n = N;
		for(int i=0;;) {
			count = 0;
			int tmp = n - i;
			if(tmp<0)
				break;
			if(i >= min)
				return Integer.MAX_VALUE;
			while(true) {
				count++;
				if(tmp/10 == 0) {
					if(button[tmp%10] == false) {
						return i+count;
					}
					else {
						i++;
						break;
					}
				}
				if(button[tmp%10]) {
					int ten =1;
					for(int j=1;j<count;j++)
						ten *= 10;
					i = i+ (n-i)%ten + 1;
					break;
				}
				tmp = tmp/10;
			}
		}
		return Integer.MAX_VALUE;
	}
	
	public static int down(int min) {
		int count;
		int n = N;
		for(int i=0;;) {
			count = 0;
			int tmp = n + i;
			if(i >= min)
				return Integer.MAX_VALUE;
			while(true) {
				count++;
				if(tmp/10 == 0) {
					if(button[tmp%10] == false) {
						return i+count;
					}
					else {
						i++;
						break;
					}
				}
				if(button[tmp%10]) {
					int ten = 1;
					for(int j=1;j<count;j++)
						ten *= 10;
					i = i+ ten - ((n+i)%ten);
					break;
				}
				tmp = tmp/10;
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception{
		int now = 100;
		int min;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		if(M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i =0;i<M;i++) {
				int num = Integer.parseInt(st.nextToken());
				button[num] = true;
			}
		}

		if(now > N) {
			min = now - N;
		}else {
			min = N - now;
		}
		
		if(now != N) {
			int d = down(min);
			int u = up(min);
			
			if(d >= u && min > u)
				min = u;
			else if(u > d && min > d)
				min = d;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(min + "");
		bw.flush();
		bw.close();
	}
}
