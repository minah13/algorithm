//1309번 문제(동물원)
import java.io.*;

public class exam_1309 {
	public static void main(String[] args) throws Exception{
		int[][] D;
		int N;
		int sum=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		D = new int[N][3];
		
		D[0][0] = 1;
		D[0][1] = 0;
		D[0][2] = 0;
		
		for(int j=0;j<3;j++) {
			for(int i=0;i<3;i++){
				if(i==j)
					D[0][i] = 1;
				else
					D[0][i] = 0;
			}
			for(int i=1;i<N;i++) {
				D[i][0] = D[i-1][0] + D[i-1][1] + D[i-1][2];
				D[i][1] = D[i-1][0] + D[i-1][2];
				D[i][2] = D[i-1][0] + D[i-1][1];
			}
			for(int i=0;i<3;i++) {
				sum += D[N-1][i];
				sum %= 9901;
			}
		}
		
		System.out.println(sum);
		
	}
}
