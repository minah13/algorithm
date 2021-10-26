//1699번 문제(제곱수의 합)
import java.io.*;

public class exam_1699 {
	public static void main(String[] args) throws Exception{
		int[] num;
		int[] min;
		int N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N+1];
		min = new int[N+1];
		
		num[1] = 1;
		min[1] = 1;
		
		int x;
		int y;
		for(int i=2;i<=N;i++) {
			int tmp = min[i-1] + 1;
			tmp = tmp*tmp;
			if(tmp==i) {
				num[i] = 1;
				min[i] = min[i-1]+1;
				continue;
			}
			min[i] = min[i-1];
			x = min[i];
			while(x>0) {
				y = i - (x*x);
				if(tmp>num[y]+1) {
					tmp = num[y]+1;
				}
				x--;
			}
			num[i] = tmp;
		}
		
		System.out.print(num[N]);
	}
}
