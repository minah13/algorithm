// k진수에서 소수 개수 구하기


import java.util.*;
import java.lang.*;

class Programmers1109 {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            int modN = n%k;
            n = n/k;
            sb.append(String.valueOf(modN));
        }
        sb.reverse();
        
        int length = sb.length();
        String numS = sb.toString();
        int start = 0;
        int end = 0;
        
        while(end < length){
            char numC = numS.charAt(end);
            if(numC == '0'){
                if(start<end){
                    String subNum = numS.substring(start,end);
                    boolean result = isPrime(Long.parseLong(subNum));
                    if(result)
                        answer++;
                }
                
                start = ++end;
                
            }else{
                end++;
            }
        }
        
        if(start<end){
            String subNum = numS.substring(start,end);
            boolean result = isPrime(Long.parseLong(subNum));
            if(result)
                answer++;
        }
        
        return answer;
    }
    
    public boolean isPrime(long n){
        boolean result = true;
        if(n<=1)
            return false;
        double num = Math.sqrt(n);
        for(int i=2;i<=num;i++){
            if(n%i==0){
                result = false;
                break;
            }
        }
        return result;
    }
}

/*
자료형 주의해서 사용!
(숫자값이 너무 커지면 int가 아닌 long으로 데이터 저장)
*/
