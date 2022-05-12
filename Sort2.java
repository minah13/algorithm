// 정렬 (가장 큰 수) 문제

import java.util.*;

class Sort2 {
    public String solution(int[] numbers) {
        
        String[] number = new String[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            number[i] = String.valueOf(numbers[i]);
        }
        
        
        Arrays.sort(number,new Comparator<String>(){
            @Override
            public int compare(String o1,String o2){
                String s1 = o1;
                String s2 = o2;
                if(s1.length()>s2.length()){
                    int minlength = s2.length();
                    int maxlength = s1.length()*2;
                    for(int i=0;i<maxlength-minlength;i++){
                        int index = i;
                        if(index>=minlength){
                            index -= minlength;
                        }
                        s2 += s2.charAt(index);
                    }
                    s1 += s1;
                }else{
                    int minlength = s1.length();
                    int maxlength = s2.length()*2;
                    for(int i=0;i<maxlength-minlength;i++){
                        int index = i;
                        if(index>=minlength){
                            index -= minlength;
                        }
                        s1 += s1.charAt(index);
                    }
                    s2 += s2;
                }
                
                int n1 = Integer.parseInt(s1);
                int n2 = Integer.parseInt(s2);
                
                
                
                return n2-n1;
            }
        }); // 배열 정렬
        
        String answer="";
        
        if(number[0].equals("0")){
            answer = "0";
        }else{
            for(int i=0;i<number.length;i++){
                answer += number[i];
            }
        }
        
        return answer;
        
    }
    
}
