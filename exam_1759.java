//1759번 문제(암호 만들기)

import java.io.*;
import java.util.*;

public class exam_1759 {
	static char[] alpha;
	static int L;
	static int C;
	
	public static void print_pwd(BufferedWriter bw, int length, int al, int bl, int start, char[] pwd) throws Exception {
		if(length == L) {
			if(al<1 || bl<2)
				return;
			for(int i=0;i<L;i++) {
				bw.write(pwd[i] + "");
			}
			bw.write("\n");
			return ;
		}
		
		for(int i=start;i<C;i++) {
			pwd[length] = alpha[i];
			if(alpha[i] == 'a' || alpha[i] == 'e' || alpha[i] == 'i' || alpha[i] == 'o' || alpha[i] == 'u') {
				print_pwd(bw,length+1,al+1,bl,i+1,pwd);
			}else {
				print_pwd(bw,length+1,al,bl+1,i+1,pwd);
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpha = new char[C];
		
		String str = br.readLine();
		for(int i=0;i<C;i++) {
			alpha[i] = str.charAt(i*2);
		}
		
		Arrays.sort(alpha);
		
		char[] pwd = new char[L];
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		print_pwd(bw,0,0,0,0,pwd);
		bw.flush();
		bw.close();
		
	}
}
