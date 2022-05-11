// Heap (이중우선순위큐) 문제

import java.util.*;

class Heap3 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int count=0;
        PriorityQueue<Integer> minqueue = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxqueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<operations.length;i++){
            String operation = operations[i];
            
            char o = operation.charAt(0);
            String numstr = operation.substring(2);
            int num = Integer.parseInt(numstr);
            
            if(o=='I'){
                count +=1;
                minqueue.add(num);
                maxqueue.add(num);
            }else if(o =='D' && num==1 && count > 0){
                maxqueue.poll();
                count -=1;
            }else if(o =='D' && num==-1 && count > 0){
                minqueue.poll();
                count -=1;
            }
            
        }
        
        if(count ==0){
            answer[0] = 0;
            answer[1] = 0;
        }else{
            PriorityQueue<Integer> tmp = new PriorityQueue<Integer>();
            ArrayList<Integer> remain = new ArrayList<Integer>();
            while(!maxqueue.isEmpty()){
                tmp.add(maxqueue.poll());
            }
            while(!minqueue.isEmpty() && !tmp.isEmpty()){
                if(tmp.peek().equals(minqueue.peek())){
                    tmp.poll();
                    remain.add(minqueue.poll());
                }else if(tmp.peek()>minqueue.peek()){
                    minqueue.poll();
                }else{
                    tmp.poll();
                }
            }
            
            answer[1] = remain.get(0);
            answer[0] = remain.get(remain.size()-1);
        }
        
        
        return answer;
    }
}
