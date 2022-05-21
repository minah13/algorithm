class DP2 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] sum = new int[triangle.length][triangle.length];
        sum[0][0] = triangle[0][0];
        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<=i;j++){
                int a = Integer.MIN_VALUE;
                if(j-1>=0){
                    a = sum[i-1][j-1] + triangle[i][j];
                }
                int b = sum[i-1][j] + triangle[i][j];
                
                if(a<b){
                    sum[i][j] = b;
                }else{
                    sum[i][j] = a;
                }
                
            }
        }
        int last = sum.length-1;
        for(int i=0;i<=last;i++){
            if(answer<sum[last][i]){
                answer = sum[last][i];
            }
        }
        
        
        return answer;
    }
}
