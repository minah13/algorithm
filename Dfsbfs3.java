// 깊이/너비 우선 탐색 (단어 변환) 문제

class Dfsbfs3 {
    public int solution(String begin, String target, String[] words) {
        int answer=0;
		boolean contain=false;
		for(int i=0;i<words.length;i++) {
			if(target.equals(words[i])) {
				contain=true;
				break;
			}
		}
		if(!contain) {
			return answer;
		}
		
		boolean[] check = new boolean[words.length];
		
		answer = isWord(begin,target,words,0,check);
		
		return answer;
    }
    
    public static int isWord(String begin,String target,String[] words,int count,boolean[] check) {
		if(begin.equals(target)) {
			return count;
		}
		int min = Integer.MAX_VALUE;
		int length = begin.length()-1;
		for(int i=0;i<words.length;i++) {
			int tmp =0;
			for(int j=0;j<begin.length();j++) {
				if(begin.charAt(j) == words[i].charAt(j)) {
					tmp +=1;
				}
			}
			if(tmp == length && check[i]==false) {
				check[i] = true;
				int result = isWord(words[i],target,words,count+1,check);
				check[i] = false;
				if(result>0 && min>result) {
					min = result;
				}
			}
		}
		if(min == Integer.MAX_VALUE) {
			min =0;
		}
		return min;
	}
}
