// 호텔 대실

import java.util.*;
import java.io.*;

class Programmers0414 {
    public int solution(String[][] book_time) {
        
        List<BookTime> booktimes = new ArrayList<>();
        
        for(int i=0;i<book_time.length;i++){
            String[] starts = book_time[i][0].split(":");
            String[] ends = book_time[i][1].split(":");
            BookTime bt = new BookTime(Integer.parseInt(starts[0])*60 + Integer.parseInt(starts[1]), Integer.parseInt(ends[0])*60 + Integer.parseInt(ends[1])+10);
            booktimes.add(bt);
        }
        
        
        Comparator<BookTime> comparator = new Comparator<BookTime>(){
            @Override
            public int compare(BookTime a, BookTime b){
                int result = 0;
                if(a.getStart() < b.getStart()){
                    result = -1;
                }else if(a.getStart() > b.getStart()){
                    result = 1;
                }
                
                return result;
            }
        };
        
        Collections.sort(booktimes,comparator);
        
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        minHeap.add(booktimes.get(0).getEnd());
        
        for(int i=1;i<booktimes.size();i++){
            int queuetop = minHeap.peek();
            BookTime tmp = booktimes.get(i);
            if(queuetop<=tmp.getStart()){
                minHeap.poll();
            }
            minHeap.add(tmp.getEnd());
        }
        
        
        
        int answer = minHeap.size();
        
        return answer;
    }
    
    class BookTime{
        private int start;
        private int end;
        
        public BookTime(int start, int end){
            this.start = start;
            this.end = end;
        }
        
        public int getStart(){
            return start;
        }
        
        public int getEnd(){
            return end;
        }
        
    }
}
