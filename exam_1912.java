//1912번 문제(연속합)
import java.io.*;
import java.util.*;

public class exam_1912 {
	public static void main(String[] args) throws Exception{
		int n;
		int[] num;
		int[] sum;
		int max;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		sum = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
			num[i] = Integer.parseInt(st.nextToken());
		
		sum[0] =num[0];
		for(int i=1;i<n;i++) {
			int tmp = sum[i-1] + num[i];
			if(tmp<num[i])
				sum[i] = num[i];
			else
				sum[i] = tmp;
		}
		max = sum[0];
		for(int i=1;i<n;i++) {
			if(max<sum[i])
				max = sum[i];
		}
		
		System.out.println(max);
	}
}
