//15988번 문제(1,2,3 더하기3)
import java.io.*;
import java.util.*;

public class exam_15988 {
	public static void main(String[] args) throws Exception{
		int T;
		int n;
		int[] m;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		m = new int[1000001];
		m[1] = 1;
		m[2] = 2;
		m[3] = 4;
		for(int i=4;i<1000001;i++) {
			m[i] = ((m[i-3] + m[i-2])%1000000009 + m[i-1])%1000000009;
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0;i<T;i++) {
			n = Integer.parseInt(br.readLine());
			bw.write(m[n] + "\n");
		}
		bw.flush();
		bw.close();
	}
}
