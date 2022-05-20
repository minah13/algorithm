// 그리디 (섬 연결하기) 문제

class Greedy5 {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        boolean[] bridge = new boolean[n];
        int[][] cost = new int[n][n];
        for(int i=0;i<costs.length;i++){
            cost[costs[i][0]][costs[i][1]] = costs[i][2];
            cost[costs[i][1]][costs[i][0]] = costs[i][2];
        }
        
        bridge[0] = true;
        
        for(int i=0;i<n-1;i++){
            int min = Integer.MAX_VALUE;
            int minindex=0;
            for(int j=1;j<n;j++){
                if(cost[0][j]>0 && min>cost[0][j] && !bridge[j]){
                    min = cost[0][j];
                    minindex=j;
                }
            }
            cost[0][minindex]=0;
            cost[minindex][0]=0;
            bridge[minindex]=true;
            for(int j=1;j<n;j++){
                if(cost[minindex][j] > 0 && !bridge[j]){
                    int k = cost[0][j];
                    int c = cost[minindex][j];
                    if(k==0 || k>c){
                        cost[0][j] = c;
                    }
                    
                }
            }
            answer += min;
            //System.out.println("index : " + minindex);
            //System.out.println("cost : " + min);
        }
        return answer;
    }
}
