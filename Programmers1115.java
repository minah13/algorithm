// 순위검색

import java.util.*;


class Programmers1115 {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        HashMap<String,ArrayList<Integer>> lang = new HashMap<>();
        HashMap<String,ArrayList<Integer>> job = new HashMap<>();
        HashMap<String,ArrayList<Integer>> career = new HashMap<>();
        HashMap<String,ArrayList<Integer>> food = new HashMap<>();
        int[] score = new int[info.length];
        
        int index=0;
        for(String str : info){
            String[] infos = str.split(" ");
            saveinfo(lang,infos[0],index);
            saveinfo(job,infos[1],index);
            saveinfo(career,infos[2],index);
            saveinfo(food,infos[3],index);
            
            score[index] = Integer.parseInt(infos[4]);
            
            index++;
        }
        
        int a=0;
        for(String q : query){
            String[] oneque = q.split(" ");
            index = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<info.length;i++){
                list.add(i);
            }
            for(String req : oneque){
                if(req.equals("and"))
                    continue;
                
                if(index == 0){
                    if(!req.equals("-")){
                        comparelist(list,lang.get(req));
                    }
                }else if(index==1){
                    if(!req.equals("-")){
                        comparelist(list,job.get(req));
                    }
                }else if(index==2){
                    if(!req.equals("-")){
                        comparelist(list,career.get(req));
                    }
                }else if(index==3){
                    if(!req.equals("-")){
                        comparelist(list,food.get(req));
                    }
                }else{
                    for(int i=0;i<list.size();i++){
                        if(score[list.get(i)] < Integer.parseInt(req)){
                            list.remove(i--);
                        }
                    }
                }
                
                
                index++;
            }
            
            answer[a++] = list.size();
            
        }
        
        return answer;
    }
    
    
    public void saveinfo(HashMap<String,ArrayList<Integer>> map, String info, int index){
        ArrayList<Integer> list = map.get(info);
        if(list == null){
            list = new ArrayList<>();
        }
        list.add(index);
        map.put(info,list);
    }
    
    
    public void comparelist(ArrayList<Integer> list1, ArrayList<Integer> list2){
        int j=0;
        int i=0;
        for(i=0;i<list1.size();i++){
            while(j<list2.size() && list1.get(i) >list2.get(j)){
                j++;
            }
            if(j>=list2.size())
                break;
            
            if(list1.get(i) < list2.get(j)){
                list1.remove(Integer.valueOf(list1.get(i)));
                i--;
            }
        }
        for(int k=i;k<list1.size();k++){
            list1.remove(k);
            k--;
        }
    }
}
