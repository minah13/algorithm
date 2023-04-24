// 마법의 엘리베이터

class Programmers0424 {
    
    int min = Integer.MAX_VALUE;
    
    public int solution(int storey) {
        
        int answer = 0;
        searchMin(storey,0);
        
        return min;
    }
    
    public void searchMin(int storey,int cur){
        if(storey==0){
            if(cur<min){
                min = cur;
            }
            return;
        }
        
        if(cur>min)
            return;
        
        int tmp = storey%10;
        searchMin(storey/10,cur+tmp);
        searchMin(storey/10+1,cur+10-tmp);
        
    }
    
}
