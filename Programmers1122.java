// 다단계 칫솔 판매

import java.lang.*;
import java.util.HashMap;

class Programmers1122 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        HashMap<String,Member> tree = new HashMap<>();
        int index=0;
        for(String name : enroll){
            Member member = new Member(referral[index],0);
            tree.put(name,member);
            index++;
        }
        index = 0;
        for(String sellername : seller){
            Member member = tree.get(sellername);
            int money = amount[index]*100;
            int uppermoney = (int)Math.floor(money*0.1);
            money = (int)Math.ceil(money*0.9);
            while(uppermoney >= 1){
                
                member.profit += money;
                tree.put(sellername,member);
                if(member.upper.equals("-")){
                    break;
                }
                sellername = member.upper;
                member = tree.get(member.upper);
                money = uppermoney;
                
                uppermoney = (int)Math.floor(money*0.1);
                money = (int)Math.ceil(money*0.9);
                
            }
            if(uppermoney < 1){
                member.profit += money;
                tree.put(sellername,member);
            }
            index++;
        }
        index=0;
        for(String name : enroll){
            Member member = tree.get(name);
            answer[index++] = member.profit;
        }
        
        return answer;
    }
    public class Member{
        String upper;
        int profit;
        
        public Member(String upper, int profit){
            this.upper = upper;
            this.profit = profit;
        }
    }
}
