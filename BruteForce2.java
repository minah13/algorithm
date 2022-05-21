// 완전탐색 (소수찾기) 문제

import java.util.*;

class BruteForce2 {
    public int solution(String numbers) {
        int answer = 0;
        String[] remain = new String[numbers.length()];
        for(int i=0;i<numbers.length();i++){
            remain[i] = String.valueOf(numbers.charAt(i));
        }
        HashSet<Integer> numlist = allnum("",remain);
        
        Iterator<Integer> iterator = numlist.iterator();
        while(iterator.hasNext()){
            int num = iterator.next();
            boolean result = true;
            for(int i=2;i<=Math.sqrt(num);i++){
                if(num%i==0){
                    result = false;
                    break;
                }
            }
            if(num ==0 || num ==1){
                result = false;
            }
            if(result){
                answer += 1;
            }
        }
             
        return answer;
    }
    
    public HashSet<Integer> allnum(String curNum, String[] remain){
        if(remain.length == 0)
            return null;
        HashSet<Integer> numset = new HashSet<Integer>();
        for(int i=0;i<remain.length;i++){
            String newNum = curNum + remain[i];
            numset.add(Integer.parseInt(newNum));
            String[] newremain = new String[remain.length-1];
            int index=0;
            for(int j=0;j<remain.length;j++){
                if(i!=j){
                    newremain[index++] = remain[j];
                }
            }
            HashSet<Integer> tmpset = allnum(newNum,newremain);
            if(tmpset != null){
                numset.addAll(tmpset);  
            }
        }
        
        return numset;
    }
}
