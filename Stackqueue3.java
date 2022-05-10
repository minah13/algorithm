// 스택/큐 (다리를 지나는 트럭) 문제

import java.util.*;

class Stackqueue3 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue <Integer> queue = new LinkedList<Integer>();
        int br_wt = 0;
        for(int i=0;i<bridge_length;i++){
            queue.add(0);
        }
        for(int i=0;i<truck_weights.length;i++){
            int front = queue.poll();
            br_wt -= front;
            answer++;
            while(br_wt+truck_weights[i] > weight){
                front = queue.poll();
                br_wt -= front;
                queue.add(0);
                answer++;
            }
            queue.add(truck_weights[i]);
            br_wt += truck_weights[i];
        }
        
        while(!queue.isEmpty()){
            queue.poll();
            answer++;
        }
        
        return answer;
    }
}
