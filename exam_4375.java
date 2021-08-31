// 문제 4375번(1)
import java.io.*;

public class exam_4375 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp;
		while((tmp=br.readLine()) != null) {
			int n = Integer.parseInt(tmp);
			int ten=10;
			int length = 2;
			long before = 1;
			if(n==1) {
				System.out.println(1);
			}
			else {
				while(true) {
					
					if((before = ((before*(ten%n)%n)+1)%n) ==0) {
						System.out.println(length);
						break;
					}
					
					length++;
				}
			}
			
		}
	}
}
