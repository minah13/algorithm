// 거리두기 확인하기
import java.util.*;

class Solution {
    
    String[] room;
    boolean result;
    
    public int[] Programmers1118(String[][] places) {
        int[] answer = new int[places.length];
        for(int i=0;i<places.length;i++){
            room = places[i];
            int sizeV = places[i].length;
            int sizeW = places[i][0].length();
            int size = sizeV*sizeW;
            result=true;
            for(int j=0;j<size;j++){
                if(room[j/sizeW].charAt(j%sizeW) == 'P'){
                    check(j/sizeW,j%sizeW,2,j/sizeW,j%sizeW);
                    //System.out.println("start >>> x:" + j/sizeW + " y:" +j%sizeW);
                    if(!result){
                        break;
                    }
                }
            }
            if(result)
                answer[i] = 1;
            else
                answer[i] = 0;
        }
        
        return answer;
    }
    
    public void check(int x, int y, int count,int originx,int originy){
        
        if(!result)
            return;
        
        if(room[x].charAt(y) == 'P' && count != 2 && !(originx==x && originy==y)){
            //System.out.println("X : " + x + "y : " + y + " count : " + count);
            result = false;
            return ;
        }
        
        if(count==0 || room[x].charAt(y) == 'X')
            return ;
        
        
        if(x+1<room.length){
            check(x+1,y,count-1,originx,originy);
        }
        if(y+1<room[0].length()){
            check(x,y+1,count-1,originx,originy);
        }
        if(y-1>=0){
            check(x,y-1,count-1,originx,originy);
        }
        
    }
}
