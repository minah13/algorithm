// 2529번 문제(부등호)

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class exam_2529 {
	
	static int k;
	static char[] inequality;
	static ArrayList<String> ans = new ArrayList<>();
	
	public static void numstr(int index, String num_s, boolean[] num) {
		if(index>k) {
			ans.add(num_s);
			
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
						String j = Integer.toString(i);
						num[i] = true;
						numstr(index+1,num_s+j,num);
						num[i] = false;
					}
				}
			}else {
				for(int i=0;i<before;i++) {
					if(num[i] ==false) {
						String j = Integer.toString(i);
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
		
		Collections.sort(ans);
		String min = ans.get(ans.size()-1);
		String max = ans.get(0);
		System.out.println(min);
		System.out.println(max);
		
		
	}
}
