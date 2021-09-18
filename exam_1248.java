// 1248번 문제(맞춰봐)

import java.io.*;
import java.util.*;

public class exam_1248 {
	static int N;
	static int[][] plusminus;
	static int[] result;
	
	public static boolean check(int index) {
		int sum=0;
		
		for(int i=0;i<=index;i++) {
			sum = sum + result[i];
		}
		
		for(int i=0;i<=index;i++) {
			if(sum>0) {
				if(plusminus[i][index]!=1)
					return false;
			}else if(sum<0) {
				if(plusminus[i][index]!=-1)
					return false;
			}else if(sum==0) {
				if(plusminus[i][index]!=0)
					return false;
			}
			sum = sum - result[i];
		}
		return true;
	}
	
	public static boolean whatisnum(int index) {
		if(index==N)
			return true;
		
		if(plusminus[index][index]== 0) {
			result[index] = 0;
			if(check(index)) {
				if(whatisnum(index+1))
					return true;
			}
		}
		
		for(int i=1;i<=10;i++) {
			if (plusminus[index][index] == 1) {
				result[index] = i;
				if(check(index)) {
					if(whatisnum(index+1))
						return true;
				}
			}else if(plusminus[index][index] == -1) {
				result[index] = -i;
				if(check(index)) {
					if(whatisnum(index+1))
						return true;
				}
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String st = br.readLine();
		plusminus = new int[N][N];
		result = new int[N];
		int m=0;
		int n=0;
		for(int i =0;i<st.length();i++) {
			char tmp = st.charAt(i);
			if(tmp == '-') {
				plusminus[m][n++] = -1;
			}else if(tmp == '+') {
				plusminus[m][n++] = 1;
			}else if(tmp == '0') {
				plusminus[m][n++] = 0;
			}
			if(n==N) {
				m = m+1;
				n = m;
			}
		}
		
		whatisnum(0);
		
		for(int i=0;i<N;i++) {
			System.out.print(result[i] + " ");
		}
	}
}
