// 해쉬 (위장)문제
import java.util.*;

class Hash3 {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String,Integer> clothesMap = new HashMap<String,Integer>();
        for(int i=0;i<clothes.length;i++){
            String cls = clothes[i][1];
            boolean check = clothesMap.containsKey(cls);
            if(check){
                int count = clothesMap.get(cls);
                clothesMap.remove(cls);
                clothesMap.put(cls,count+1);
            }else{
                clothesMap.put(cls,1);
            }
        }
        for(String s: clothesMap.keySet()){
            int tmp = clothesMap.get(s);
            answer = answer * (tmp+1);
        }
        
        answer = answer -1;
        
        return answer;
    }
}
