// 야간 전술보행 문제

import java.util.*;
import java.io.*;

class Programmers1102 {
    public int solution(int distance, int[][] scope, int[][] times) {
        
        int answer = distance;
        
        for(int empNo=0;empNo<times.length;empNo++){
            
            int workTime = times[empNo][0];
            int restTime = times[empNo][1];
            
            int passStart = scope[empNo][0];
            int passEnd = scope[empNo][1];
            if(passStart>passEnd){
                int tmp = passStart;
                passStart = passEnd;
                passEnd = tmp;
            }
            
            boolean[] workCheck = new boolean[passEnd+1];
            
            int time=1;
            int whatDo = 0;
            while(time<=passEnd){
                if(whatDo == 0){
                    for(int tmp=time;tmp<time+workTime;tmp++){
                        if(tmp>passEnd)
                            break;
                        workCheck[tmp] = true;
                    }
                    whatDo = 1;
                    time = time+workTime;
                }else if(whatDo == 1){
                    for(int tmp=time;tmp<time+restTime;tmp++){
                        if(tmp>passEnd)
                            break;
                        workCheck[tmp] = false;
                    }
                    whatDo = 0;
                    time = time+restTime;
                }
            }
            
            
            for(int t=passStart;t<=passEnd;t++){
                if(workCheck[t]){
                    if(answer > t)
                        answer = t;
                    break;
                }
            }
            
        }
        
        
        return answer;
    }
}
