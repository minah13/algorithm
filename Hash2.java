// 해시 (전화번호 목록) 문제

import java.util.*;

class Hash2 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        boolean answer = true;
		HashSet<String> phone = new HashSet<String>();
		for(int i=0;i<phone_book.length;i++) {
			for(int j=0;j<phone_book[i].length();j++) {
				String tmp = phone_book[i].substring(0, j+1);
				if(phone.contains(tmp)) {
					answer=false;
					return answer;
				}
			}
			phone.add(phone_book[i]);
		}
		
		
		return answer;
    }
}
