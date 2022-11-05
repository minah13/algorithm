// 표 편집

import java.util.*;

class Programmers1105_ {
    public String solution(int n, int k, String[] cmd) {
        StringBuilder stringbuilder = new StringBuilder("O".repeat(n));
        int[] pre = new int[n];
        int[] nxt = new int[n];
        int cur = k;
        Stack<Node> stack = new Stack<>();
        
        for(int i=0;i<n;i++){
            pre[i] = i-1;
            nxt[i] = i+1;
        }
        nxt[n-1] = -1;
        
        for(int i=0;i<cmd.length;i++){
            char command = cmd[i].charAt(0);
            if(command == 'U'){
                String[] commands = cmd[i].split(" ");
                int num = Integer.parseInt(commands[1]);
                while(num-- > 0){
                    cur = pre[cur];
                }
            }else if(command == 'D'){
                String[] commands = cmd[i].split(" ");
                int num = Integer.parseInt(commands[1]);
                while(num-- > 0){
                    cur = nxt[cur];
                }
            }else if(command == 'C'){
                Node node = new Node(pre[cur],cur,nxt[cur]);
                stack.push(node);
                
                stringbuilder.setCharAt(cur,'X');
                
                if(pre[cur] != -1)
                    nxt[pre[cur]] = nxt[cur];
                if(nxt[cur] != -1)
                    pre[nxt[cur]] = pre[cur];
                
                if(nxt[cur] != -1){
                    cur = nxt[cur];
                }else{
                    cur = pre[cur];
                }
            }else if(command == 'Z'){
                Node node = stack.pop();
                
                stringbuilder.setCharAt(node.cur,'O');
                
                if(node.pre != -1)
                    nxt[node.pre] = node.cur;
                if(node.nxt != -1)
                    pre[node.nxt] = node.cur;
            }
        }
        
        
        return stringbuilder.toString();
    }
    
    public class Node{
        int pre;
        int cur;
        int nxt;
        
        public Node(int pre, int cur, int nxt){
            this.pre = pre;
            this.cur = cur;
            this.nxt = nxt;
        }
    }
}




/*
import java.util.*;

class Programmers1105 {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        
        boolean[] table = new boolean[n];
        int current = k;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<n;i++){
            table[i] = true;
        }
        
        for(int i=0;i<cmd.length;i++){
            if(cmd[i].length() == 1){
                String command = cmd[i];
                if(command.equals("C")){
                    stack.add(current);
                    table[current] = false;
                    if(current != n-1){
                        current += 1;
                        while(!table[current]){
                            current += 1;
                        }
                    }else{
                        current -= 1;
                        while(!table[current]){
                            current -= 1;
                        }
                    }
                }else if(command.equals("Z")){
                    int num = stack.pop();
                    table[num] = true;
                    
                }
            }else{
                String[] commands = cmd[i].split(" ");
                String command = commands[0];
                int num = Integer.parseInt(commands[1]);
                if(command.equals("U")){
                    for(int j=1;j<=num;j++){
                        while(!table[current-1]){
                            current -= 1;
                        }
                        current -=1;
                    }
                    
                }else if(command.equals("D")){
                    for(int j=1;j<=num;j++){
                        while(!table[current+1]){
                            current += 1;
                        }
                        current += 1;
                    }
                   
                }
            }
            
            
        }
        
        for(int i=0;i<n;i++){
            if(table[i]){
                answer += "O";
            }else{
                answer += "X";
            }
        }
        
        return answer;
    }
}

- StringBuilder를 사용하면 문자열을 합치는데 걸리는 시간을 상당히 줄일 수 있다.
- 그럼에도 시간초과가 발생.

*/
