// Greedy (큰수 만들기)

package programmers;

public class Greedy3 {

	public static void main(String[] args) {
		String number = "1924";
		int k = 2;
		
		String result = solution(number,k);
		System.out.println(result);
	}
	
	public static String solution(String number, int k) {
		String answer="";
		
		int n = 0;
		boolean[] check = new boolean[number.length()];
		boolean c=true;  // 모든 숫자에서 앞쪽 숫자가 더 큰지 저장
		
		
		for(int j=0;j<number.length()-1;j++) {
				if(j<0)
					j=0;
			
				int tmp = j+1;   // j 바로 다음숫자 
				if(!check[j]) {   // j가 제거한 숫자가 아니라면
					
					while(check[tmp]) {  // tmp가 제거한 숫자라면
						tmp++;
						if(tmp==number.length())
							break;
					}
					if(tmp<number.length() && number.charAt(j) < number.charAt(tmp)) {
						n++;
						check[j] = true;
						tmp = j;
						while(check[j]) {
							j--;
							if(j<0) {
								j=tmp+1;
								break;
							}
						}
						j--;
						c =true;
					}
					
					if(n==k)
						break;
					
				}
				
		}
		
		
		
		if(n!=k) {
			for(int i=number.length()-1;i>=0;i--) {
				if(check[i]==false) {					
					n++;
					check[i] = true;
					if(n==k)
						break;
				}
			}
		}
		
		for(int i=0;i<number.length();i++) {
			
			if(check[i]!=true) {
				answer += number.charAt(i);
			}
			
		}
		
		
		return answer;
	}

}
