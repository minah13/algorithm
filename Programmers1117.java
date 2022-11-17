// 피로도
import java.util.*;

class Programmars1117 {
    static int max = 0;
    public int solution(int k, int[][] dungeons) {
        
        boolean[] check = new boolean[dungeons.length];
        travel(check,k,dungeons,0,0);
        
        return max;
    }
    
    public void travel(boolean[] check, int hp, int[][] dungeons, int count,int index){
        if(index==dungeons.length || hp==0){
            if(max<count)
                max = count;
            return;
        }
        for(int i=0;i<dungeons.length;i++){
            if(!check[i]){
                if(dungeons[i][0]<=hp){
                    check[i] = true;
                    travel(check,hp-dungeons[i][1],dungeons,count+1,index+1);
                    check[i] = false;
                }else if(dungeons[i][0]>hp){
                    check[i] = true;
                    travel(check,hp,dungeons,count,index+1);
                    check[i] = false;
                }
            }
        }
        
    }
}
