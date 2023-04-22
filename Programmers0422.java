// 무인도 여행

import java.util.*;

class Programmers0422 {
    
    static int[] dI = {0,-1,0,1};
    static int[] dJ = {-1,0,1,0};
    
    boolean[][] visited;
    int[][] map;
    
    public int[] solution(String[] maps) {
        
        int height = maps.length;
        int width = maps[0].length();
        
        visited = new boolean[height][width];
        
        map = new int[height][width];
        
        Queue<Integer> queue = new PriorityQueue<Integer>();
        
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                String tmp = maps[i].substring(j,j+1);
                if(tmp.equals("X")){
                    map[i][j] = 0;
                    visited[i][j] = true;
                }else{
                    map[i][j] = Integer.parseInt(tmp);
                }
            }
        }
        
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(!visited[i][j]){
                    int islandSize = travelIsland(i,j);
                    queue.add(islandSize);
                }
            }
            
        }
        
        
        int[] answer;
        int queuesize = queue.size();
        if(queuesize==0){
            answer = new int[1];
            answer[0] = -1;
        }else{
            answer = new int[queuesize];
            for(int i=0;i<queuesize;i++){
                answer[i] = queue.poll();
            }
        }
        
        return answer;
    }
    
    public int travelIsland(int height, int width){
        
        visited[height][width] = true;
        int result = map[height][width];
        for(int i=0;i<4;i++){
            if(isIsland(height+dI[i], width+dJ[i]) && !visited[height+dI[i]][width+dJ[i]]){
                result += travelIsland(height+dI[i],width+dJ[i]);
            }
        }
        /*if(height+1<map.length && !visited[height+1][width]){
            result += travelIsland(height+1,width);
        }
        if(height-1>=0 && !visited[height-1][width]){
            result += travelIsland(height-1,width);
        }
        if(width+1<map[0].length && !visited[height][width+1]){
            result += travelIsland(height,width+1);
        }
        if(width-1>=0 && !visited[height][width-1]){
            result += travelIsland(height,width-1);
        }*/
        return result;
    }
    
    public boolean isIsland(int height, int width){
        if(height>=map.length)
            return false;
        else if(height<0)
            return false;
        else if(width>=map[0].length)
            return false;
        else if(width<0)
            return false;
        
        return true;
    }
    
}
