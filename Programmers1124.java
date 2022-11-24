// 문자열 압축
import java.util.*;

class Programmers1124 {
    public int solution(String s) {
        int answer = s.length();
        int len = (s.length()/2)+1;
        for(int i=1;i<=len;i++){

            int compactLen = compactStr(s,i);
            
            if(compactLen<answer){
                answer = compactLen;
            }
        }
        
        return answer;
    }
    
    public int compactStr(String s, int len){
        int result = 0;
        int start = 0;
        int end = len;
        int strLen = s.length();
        while(end<=strLen){
            int count=1;
            String str1 = s.substring(start,end);
            
            start = end;
            end = end+len;
            while(end<=strLen){
                String str2 = s.substring(start,end);
                if(str2.equals(str1)){
                    count++;
                    start = end;
                    end = end + len;
                }else{
                    break;
                }
            }
            
            if(count!=1){
                String c = String.valueOf(count);
                result += c.length();
            }
            result += len;
        }
        
        if(start<strLen){
            result += (s.length()-start);
        }
        
        return result;
    }
}
