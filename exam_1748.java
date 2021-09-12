// 1748번 문제(수 이어쓰기1)

import java.io.*;
import java.util.*;

public class exam_1748 {
	public static void main(String[] args) throws Exception{
		int N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int length = 0;
		int ten = 10;
		for(int i =1;;i++) {
			if(N/ten==0) {
				length += (N-((ten/10)-1))*i;
				break;
			}else {
				length += 9*(ten/10)*i;
				ten *= 10;
			}
		}
		System.out.println(length);
	}
}
