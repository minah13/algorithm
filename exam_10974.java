//10974번 문제(모든 순열)

import java.io.*;

public class exam_10974 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static boolean nextnum(int N, int[] num) throws Exception{
		int k=-1;
		for(int i=N-1;i>0;i--) {
			if(num[i-1]<num[i]) {
				k = i;
				break;
			}
		}
		
		if(k==-1)
			return false;
		
		for(int i=N-1;i>=k;i--) {
			if(num[k-1]<num[i]) {
				int tmp = num[k-1];
				num[k-1] = num[i];
				num[i] = tmp;
				break;
			}
		}
		
		int o = N-1;
		while(o>k) {
			int tmp = num[k];
			num[k] = num[o];
			num[o] = tmp;
			o--;
			k++;
		}
		
		for(int i=0;i<N;i++)
			bw.write(num[i] + " ");
		
		bw.write("\n");
		
		return true;
	}
	
	public static void main(String args[]) throws Exception{
		int N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] num;
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		for(int i=1;i<=N;i++) {
			num[i-1] = i;
			bw.write(num[i-1] + " ");
		}
		bw.write("\n");
		
		while(nextnum(N,num)) {
			
		}
		
		bw.flush();
		bw.close();
	}
}
