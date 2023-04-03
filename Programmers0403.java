// 과제 진행하기
import java.util.*;

class Programmers0403 {
    public String[] solution(String[][] plans) {
        
        // plans 시작시간 정리
        for(int i=0;i<plans.length;i++){
            String[] start = plans[i][1].split(":");
            int start_hour = Integer.parseInt(start[0]);
            int start_min = Integer.parseInt(start[1]);
            
            int start_time = start_hour*60 + start_min;
            plans[i][1] = String.valueOf(start_time);
            
        }
        
        // plans 시작 순서대로 정렬
        Arrays.sort(plans, new Comparator<String[]>(){
           @Override
            public int compare(String[] s1, String[] s2){
                int result=0;
                
                int start1 = Integer.parseInt(s1[1]);
                int start2 = Integer.parseInt(s2[1]);
                
                if(start1<start2){
                    result = -1;
                }else if(start1>start2){
                    result = 1;
                }
                
                return result;
                
            }
        });
        
        // 끝내지 못한 과제 저장
        Stack<Integer> stack = new Stack<>();
        
        // 결과저장
        String[] answer = new String[plans.length];
        int answer_index=0;
        
        
        for(int i=0;i<plans.length-1;i++){
            int cur_start = Integer.parseInt(plans[i][1]);
            int cur_time = Integer.parseInt(plans[i][2]);
            int next_start = Integer.parseInt(plans[i+1][1]);
            if(cur_start+cur_time>next_start){ // 
                plans[i][2] = String.valueOf(cur_start+cur_time-next_start);
                stack.push(i);
            }else{
                answer[answer_index++] = plans[i][0];
                cur_start = cur_start + cur_time;
                if(!stack.empty()){
                    int doing_time = Integer.parseInt(plans[stack.peek()][2]);
                    while(cur_start+doing_time<=next_start){
                        int tmp = stack.pop();
                        answer[answer_index++]=plans[tmp][0];
                        cur_start = cur_start + doing_time;
                        if(!stack.empty()){
                            doing_time = Integer.parseInt(plans[stack.peek()][2]);
                        }else{
                            break;
                        }
                    }
                }
                
                if(cur_start!=next_start && !stack.empty()){
                    int n = stack.peek();
                    int t = Integer.parseInt(plans[n][2]);
                    plans[n][2] = String.valueOf(t - (next_start-cur_start));
                }
                
            }
        }
        
        answer[answer_index++] = plans[plans.length-1][0];
        
        while(!stack.empty()){
            int index = stack.pop();
            answer[answer_index++] = plans[index][0];
        }
        
        
        return answer;
    }
}
