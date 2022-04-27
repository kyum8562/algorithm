function solution(participant, completion){

    let hash = new Map();
    for(let i of participant){
        if(!hash.get(i)) hash.set(i, 1);
        else hash.set(i, hash.get(i) +1)
    } 
    for(let x of completion){
        hash.get(x) ? hash.set(x, hash.get(x)-1 ) : 1;
    }
    console.log(hash);
    for(let [k, v] of hash){
        if(v>0) return k;
    }

}

console.log(solution(["mislav", "stanko", "mislav", "ana"], ["stanko", "ana", "mislav"]));
console.log(solution(["marina", "josipa", "nikola", "vinko", "filipa"], ["josipa", "filipa", "marina", "nikola"]));
