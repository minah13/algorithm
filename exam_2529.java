// 2529번 문제(부등호)

import java.io.*;

public class exam_2529 {
	
	static long max = Long.MIN_VALUE;
	static long min = Long.MAX_VALUE;
	static String max_str;
	static String min_str;
	static int k;
	static char[] inequality;
	
	public static void numstr(int index, String num_s, boolean[] num) {
		if(index>k) {
			long tmp = Long.parseLong(num_s);
			if(tmp>max)
			{
				max = tmp;
				max_str = num_s;
			}
			if(tmp<min) {
				min = tmp;
				min_str = num_s;
			}
			
			return ;
		}
		
		if(index==0) {
			for(int i=0;i<10;i++) {
				String j =String.valueOf(i);
				num[i] = true;
				numstr(index+1,num_s+j,num);
				num[i] = false;
			}
		}else {
			char tmp = num_s.charAt(index-1);
			int before = Character.getNumericValue(tmp);
			char equ = inequality[index-1];
			if(equ=='<') {
				for(int i=before+1;i<10;i++) {
					if(num[i]==false) {
						String j = String.valueOf(i);
						num[i] = true;
						numstr(index+1,num_s+j,num);
						num[i] = false;
					}
				}
			}else {
				for(int i=0;i<before;i++) {
					if(num[i] ==false) {
						String j = String.valueOf(i);
						num[i] = true;
						numstr(index+1,num_s+j,num);
						num[i] = false;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		String str = br.readLine();
		inequality = new char[k];
		for(int i=0;i<k;i++) {
			inequality[i] = str.charAt(i*2);
		}
		
		boolean[] num = new boolean[10];
		
		numstr(0,"",num);
		
		System.out.println(max_str);
		System.out.println(min_str);
	}
}
