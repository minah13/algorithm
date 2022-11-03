// 주차 요금 계산

import java.io.*;
import java.util.*;

class Programmers1103 {
    public int[] solution(int[] fees, String[] records) {
        
        int baseMin = fees[0];
        int baseFee = fees[1];
        int perMin = fees[2];
        int perFee = fees[3];
        
        HashMap<String,Integer> carMin = new HashMap<>();
        HashMap<String,String> parkingLot = new HashMap<>();
        for(int i=0;i<records.length;i++){
            String[] record = records[i].split(" ");
            
            if(record[2].equals("IN")){
                parkingLot.put(record[1],record[0]);
            }else{
                String inTime = parkingLot.remove(record[1]);
                String[] inTimes = inTime.split(":");
                String[] outTimes = record[0].split(":");
                int hour = Integer.parseInt(outTimes[0]) - Integer.parseInt(inTimes[0]);
                int min = Integer.parseInt(outTimes[1]) - Integer.parseInt(inTimes[1]);
                if(min <0){
                    min += 60;
                    hour -= 1;
                }
                
                if(carMin.containsKey(record[1])){
                    int tmp = carMin.remove(record[1]);
                    carMin.put(record[1],hour*60+min+tmp);
                }else{
                    carMin.put(record[1], hour*60+min);
                }
            }
        }
        
        
        for(String key : parkingLot.keySet()){
            String inTime = parkingLot.get(key);
            String[] inTimes = inTime.split(":");
            int hour = 23 - Integer.parseInt(inTimes[0]);
            int min = 59 - Integer.parseInt(inTimes[1]);
                
            if(carMin.containsKey(key)){
                int tmp = carMin.remove(key);
                carMin.put(key,hour*60+min+tmp);
            }else{
                carMin.put(key, hour*60+min);
            }
        }
        
        Map<String, Integer> sortedMap = new TreeMap<>(carMin);
        int[] answer = new int[sortedMap.size()];
        int index=0;
        for(String key : sortedMap.keySet()){
            int minute = sortedMap.get(key);
            if(baseMin>minute){
                answer[index++] = baseFee;
            }else{
                int addMin = minute - baseMin;
                if(addMin%perMin == 0){
                    answer[index++] = baseFee + ((addMin/perMin)*perFee);
                }else{
                    answer[index++] = baseFee + ((addMin/perMin + 1)*perFee);
                }
                
            }
        }
        
            
        return answer;
    }
}
