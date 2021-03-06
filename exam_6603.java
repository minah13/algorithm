// 6603 문제(로또)
// 재귀함수 이용
// BufferedWriter -> close 필수! (메모리 초과), 매개변수 이용
// 매개변수 ++ 연산자 사용시, 해당 값 변경됨 주의!

import java.io.*;
import java.util.*;

public class exam_6603 {
	static int k;
	static int[] S;
	static int[] six_num;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			six_num = new int[6];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) {
				break;
			}
			
			S = new int[k];
			for(int i =0;i<k ; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			lotto(bw, 0,0);
			
			
			bw.write("\n");
			
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	public static void lotto(BufferedWriter bw, int choice, int count) throws Exception{
		if(count == 6) {
			for(int i=0;i<6;i++) {
				bw.write(six_num[i] + " ");
			}
			bw.write("\n");
			
		}
		else if(S.length <= choice) {
			return;
		}
		else {
			six_num[count] = S[choice];
			lotto(bw,choice+1,count+1);
			lotto(bw,choice+1,count);
		}
	}

	
}
