function Hash3(clothes) {
    let answer = 1;
    let map = new Map();
    for(let i=0;i<clothes.length;i++){
        let cls = clothes[i][1];
        if(map.get(cls)!=undefined){
            let count = map.get(cls);
            map.delete(cls);
            map.set(cls,count+1);
        }
        else{
            map.set(cls,1);
        }
    }
    for(let c of map.values()){
        answer *= (c+1);
    }
    
    answer -= 1;
    
    return answer;
}
