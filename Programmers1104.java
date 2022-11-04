// 양궁대회

class Programmers1104 {
    
    int scorediff=0;
    int[] answer= new int[11];
    
    public int[] solution(int n, int[] info) {        
        int[] lion = new int[11];
        
        game(n,info,lion,0,0,10);
        
        if(scorediff == 0){
            answer = new int[1];
            answer[0] = -1;
        }
        return answer;
    }
    
    public void game(int arrow, int[] apeach,int[] lion, int apeachScore,int lionScore,int num){
        if(num<0){
            if(scorediff<lionScore-apeachScore){
                scorediff=lionScore-apeachScore;
                copyarray(answer,lion);
            }else if(scorediff==lionScore-apeachScore){
                for(int i=answer.length-1;i>=0;i--){
                    if(answer[i]>lion[i]){
                        break;
                    }else if(answer[i]<lion[i]){
                        copyarray(answer,lion);
                        break;
                    }
                }
            }
            
            return ;
        }
        
        int length = answer.length-1;
        int apeachArrow = apeach[length-num];
        int lionArrow = apeachArrow + 1;
        
        if(num != 0){
            
            if(arrow-lionArrow >= 0){
                lion[length-num] = lionArrow;
                game(arrow-lionArrow,apeach,lion,apeachScore,lionScore+num,num-1);
            }

            lion[length-num] = 0;
            if(apeachArrow == 0){
                game(arrow,apeach,lion,apeachScore,lionScore,num-1);  
            }else{
                game(arrow,apeach,lion,apeachScore+num,lionScore,num-1);
            }
        }else{
            lion[length-num] = arrow;
            game(0,apeach,lion,apeachScore,lionScore,num-1);
            lion[length-num] = 0;
        }
        
        
        return;
        
    }
    
    public void copyarray(int[] a, int[] b){
        for(int i=0;i<a.length;i++){
            a[i] = b[i];
        }
    }
}
