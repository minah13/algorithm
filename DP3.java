// DP (등굣길) 문제

import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        boolean[][] noway = new boolean[m][n];
        for(int i=0;i<puddles.length;i++){
            int n1 = puddles[i][0];
            int n2 = puddles[i][1];
            noway[n1-1][n2-1] = true;
        }

        int[][] path = new int[m][n];
        Queue <int[]> loc = new LinkedList<int[]>();
        loc.add(new int[]{0,0});
        path[0][0] = 1;
        boolean [][] check = new boolean[m][n];
        check[0][0] = true;
        while(loc.size()!=0){
            int[] tmp = loc.poll();
            int b = tmp[1];
            int r = tmp[0];
            if(b+1<=n-1 && !noway[r][b+1]){
                path[r][b+1] += path[r][b];
                path[r][b+1] %= 1000000007;
                if(check[r][b+1]==false &&(r<m-1 || b+1 < n-1)){
                    loc.add(new int[]{r,b+1});
                    check[r][b+1] = true;
                }
            }
            if(r+1<=m-1 && !noway[r+1][b]){
                path[r+1][b] += path[r][b];
                path[r+1][b] %= 1000000007;
                if(check[r+1][b]==false && (r+1<m-1 || b<n-1)){
                    loc.add(new int[]{r+1,b});
                    check[r+1][b] = true;
                }
            }

        }


        return path[m-1][n-1];
    }

}
