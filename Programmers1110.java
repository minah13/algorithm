// 행렬 테두리 회전하기


class Programmers1110 {
    
    int[][] graph;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        graph = new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                graph[i][j] = i*columns + j+1;
            }
        }
        
        for(int i=0;i<queries.length;i++){
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];
            
            int min = turn(x1-1,y1-1,x2-1,y2-1);
            
            answer[i] = min;
        }
        
        return answer;
    }
    
    public int turn(int x1,int y1, int x2, int y2){
        int saveNum = graph[x1][y1];
        int min = graph[x1][y1];
        for(int i=y1;i<y2;i++){
            int tmp = graph[x1][i+1];
            graph[x1][i+1] = saveNum;
            saveNum = tmp;
            if(saveNum<min){
                min = saveNum;
            }
        }
        for(int i=x1;i<x2;i++){
            int tmp = graph[i+1][y2];
            graph[i+1][y2] = saveNum;
            saveNum = tmp;
            if(saveNum<min){
                min = saveNum;
            }
        }
        
        for(int i=y2;i>y1;i--){
            int tmp = graph[x2][i-1];
            graph[x2][i-1] = saveNum;
            saveNum = tmp;
            if(saveNum<min){
                min = saveNum;
            }
        }
        for(int i=x2;i>x1;i--){
            int tmp = graph[i-1][y1];
            graph[i-1][y1] = saveNum;
            saveNum = tmp;
            if(saveNum<min){
                min = saveNum;
            }
        }
        return min;
    }
}
