// 멀쩡한 사각형
import java.util.*;

class Programmers1129 {
    public long solution(long w, long h) {
        long square = w*h;
        long gcdValue = gcd(w,h);
        w = w/gcdValue;
        h = h/gcdValue;
        
        long travelValue = travel(w,h);
        long emptySpace = gcdValue * travelValue;
        
        long answer = square - emptySpace;
        
        return answer;
        
    }
    
    public long gcd(long x, long y){
        long min=x;
        long max=y;
        if(x>y){
            min = y;
            max = x;
        }
        
        while(min!=0){
            long tmp = max%min;
            max = min;
            min = tmp;
        }
        
        return max;
        
    }
    
    public long travel(long x, long y){
        return x+y-1;
    }
}
