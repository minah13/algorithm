// 순위 검색

import java.util.*;


class Programmers1115_s {
    
    static HashMap<String,ArrayList<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        
        for(String str : info){
            String[] infos = str.split(" ");
            
            saveall(infos,"",0);
        }
        
        
        for (String key : map.keySet())
            Collections.sort(map.get(key),Collections.reverseOrder());
        
        
        int a=0;
        for(String q : query){
            StringBuilder sb = new StringBuilder();
            String[] oneque = q.split(" ");
            int index = 0;
            ArrayList<Integer> list = new ArrayList<>();
            
            for(String req : oneque){
                if(req.equals("and"))
                    continue;
                
                if(index++ < 4){
                    sb.append(req);
                }
                else{
                    int score = Integer.parseInt(req);
                    list = map.get(sb.toString());
                    if(list == null){
                        answer[a++] = 0;
                    }else{
                        //Collections.sort(list,Collections.reverseOrder());
                        int result = binarySearch(list,score);
                        answer[a++] = result;
                    }
                }
                
            }
            
        }
        
        return answer;
    }
    
    public int binarySearch(ArrayList<Integer> list, int score){
        int front = 0;
        int back = list.size()-1;
        
        while(front<=back){
            int middle = (front+back)/2;
            if(list.get(middle)<score){
                back = middle -1;
            }else{
                front = middle +1;
            }
        }
        return front;
    }
    
    
   public void saveall(String[] info,String str,int index){
       if(index==info.length-1){
           ArrayList<Integer> list = new ArrayList<>();
           if(map.get(str) != null){
               list = map.get(str);
           }
           list.add(Integer.parseInt(info[index]));
           map.put(str,list);
           return;
       }
       saveall(info,str+info[index],index+1);
       saveall(info,str+"-",index+1);
   }
}

/*
이분탐색을 적극활용하여 시간 효율성을 높임! (반복문을 통해 하나씩 살펴보는 것보다 훨씬 효율적)
이분탐색하는 방법 다시 혼자서 코드 작성해보기!
map 안에 있는 리스트를 한번에 정렬하는 것보다 쿼리가 들어올 때마다 정렬시키는 것이 더 효율적일 것이라 생각했는데
query의 개수를 생각해보면 4 * 3 * 3 * 3 = 108가지이고, query는 최대 100000개 주어지기 때문에 더욱 시간이 오래걸린다.
또 이미 정렬한 리스트를 다시 정렬하는 경우가 생길 수도 있기 때문에 비효율적인 방법이었다.
*/
