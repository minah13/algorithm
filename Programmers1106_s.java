// 메뉴 리뉴얼

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

class Programmers1106_s {
    
    HashMap<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        ArrayList<String> list = new ArrayList<>();
        
        // orders 오름차순 String으로 변경 
        for(int i=0;i<orders.length;i++){
            char[] charArray = orders[i].toCharArray();
            Arrays.sort(charArray);
            orders[i] = String.valueOf(charArray);
        }
        
        for(int i=0;i<course.length;i++){
            int length = course[i];
            int max = Integer.MIN_VALUE;
            
            for(int j=0;j<orders.length;j++){
                StringBuilder sb = new StringBuilder();
                makecourse(orders[j],sb,length,0);
                
            }
            
            for(String combi : map.keySet()){
                if(max<map.get(combi)){
                    max = map.get(combi);
                }
            }
            if(max>=2){
                for(Entry <String,Integer> entry : map.entrySet()){
                    int value = entry.getValue();
                    if(value==max){
                        list.add(entry.getKey());
                    }
                }
            }
            map.clear();
        }
        
        Collections.sort(list);
        
        String[] answer = new String[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public void makecourse(String str, StringBuilder sb, int length,int index){
        if(length == sb.length()){
            map.put(sb.toString(), map.getOrDefault(sb.toString(),0)+1);
            return;
        }
        
        for(int i=index;i<str.length();i++){
            sb.append(str.charAt(i));
            makecourse(str,sb,length,i+1);
            sb.delete(sb.length()-1,sb.length());
        }
    }
}

/*
할 수 있는 모든 조합을 해보는 경우 재귀함수 사용!
*/
