//11723번 문제(집합)

import java.io.*;
import java.util.*;

public class exam_11723 {
	public static void main(String args[]) throws Exception{
		int M;
		long S=0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		M = Integer.parseInt(br.readLine());
		
		for(int i=0;i<M;i++) {
			String act = br.readLine();
			int num=0;
			if(act.equals("all") == false && act.equals("empty")==false) {
				StringTokenizer st = new StringTokenizer(act);
				act = st.nextToken();
				num = Integer.parseInt(st.nextToken());
			}
			
			if(act.equals("add")) {
				S = S | (1<<num);
			}else if(act.equals("check")) {
				if(S == (S | (1<<num))) {
					bw.write(1 + "\n");
				}else {
					bw.write(0 + "\n");
				}
			}else if(act.equals("remove")) {
				S = S & ~(1<<num);
			}else if(act.equals("toggle")) {
				S = S ^ (1<<num);
			}else if(act.equals("all")) {
				S = (1<<21)-1;
			}else if(act.equals("empty")) {
				S = 0;
			}
		}
		
		bw.flush();
		bw.close();
	}
}
