// 정렬 (H-index) 문제

import java.util.*;

class Sort3 {
    public int solution(int[] citations) {
        int answer = 0;
		Integer tmp[] = new Integer[citations.length];
		
		for(int i=0;i<citations.length;i++) {
			tmp[i] = citations[i];
		}
		
		Arrays.sort(tmp,Collections.reverseOrder());
		
		int count = tmp[0];   // 인용수
		int i=1;   // 논문 개수
	
		while(i<citations.length) { //6,5,3,1,0
			/// 5,5,5,5
			
			while(i<citations.length && count==tmp[i]) {
				i++;
			}
			
			if(count <=i) {
				answer = count;
				break;
			}
			
			count--;
			
		}
		
		if(answer==0) {			
			while(count>=0) {
				if(count <=i) {
					answer = count;
					break;
				}
				count--;
			}
		}
		
		
		return answer;
    }
}
