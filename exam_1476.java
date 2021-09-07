// 1476번 문제(날짜 계산)

import java.io.*;
import java.util.*;

public class exam_1476 {
	static int[] esm;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		esm = new int[3];
		for(int i=0;i<3;i++) {
			esm[i] = Integer.parseInt(st.nextToken());
		}
		
		while(true) {
			if(esm[0] == esm[1] && esm[0] == esm[2])
				break;
			int min = esm[0];
			int min_index = 0;
			for(int i=1;i<3;i++) {
				if(min>esm[i]) {
					min = esm[i];
					min_index = i;
				}
			}
			
			if(min_index == 0) {
				esm[0] += 15;
			}else if(min_index == 1) {
				esm[1] +=28;
			}else if(min_index == 2) {
				esm[2] += 19;
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(esm[0] + "");
		bw.flush();
		bw.close();
	}
}
