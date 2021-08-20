// 14888번 문제(연산자 끼워넣기)
// 배열(깊은 복사, 얕은 복사) 주의!
// 매개변수 값 변경되는 것 주의!

import java.io.*;
import java.util.*;

public class exam_14888 {
	static int N;
	static int[] num;
	static int[] operator;
	static int min=Integer.MAX_VALUE;
	static int max=Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		operator = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<4;i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		minmax(operator,0,num[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void minmax(int[] op,int index,int result) {
		if(index == N-1) {
			if(max < result) {
				max = result;
			}
			if(min > result) {
				min = result;
			}
			return;
		}
		else if(index>=N)
			return ;
		for(int i = 0;i<4;i++) {
			if(op[i] >0) {
				int[] opera = new int[4];
				for(int j = 0; j< 4;j++) {
					opera[j] = op[j];
				}
				opera[i] = opera[i]-1;
				int tmp = 0;
				if(i==0) {
					tmp = result + num[index+1]; 
				}else if(i==1) {
					tmp = result - num[index+1];
				}else if(i==2) {
					tmp = result * num[index+1];
				}else if(i==3) {
					tmp = result / num[index+1];
				}
				minmax(opera,index+1,tmp);
			}
		}
		
	}
}
