// 삼각 달팽이

import java.util.*;

class Programmers1123 {
    public int[] solution(int n) {
        int size = 0;
        for(int i=1;i<=n;i++){
            size += i;
        }
        
        int[] answer = new int[size];
        int[][] snail = new int[n][n];
        int num =1;
        
        int x=0;
        int y=0;
        int way=1;
        int len = n;
        while(num <= size){
            if(way == 1){
                for(int i=0;i<len;i++){
                    snail[y++][x] = num++;
                }
                way = 2;
                y--;
                x++;
                len--;
            }else if(way == 2){
                for(int i=0;i<len;i++){
                    snail[y][x++] = num++;
                }
                way = 3;
                y--;
                x -= 2;
                len--;
            }else if(way == 3){
                for(int i=0;i<len;i++){
                    snail[y--][x--] = num++;
                }
                way = 1;
                y += 2;
                x++;
                len--;
                
            }
        }
        
        int index=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                answer[index++] = snail[i][j];
            }
        }
        
        return answer;
    }
}
