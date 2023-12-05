function solution(k, tangerine) {
    let cnt = tangerine.length - k;
    let map = {};
    tangerine.forEach((v) => {
        // if(v in map) map[v] ++;
        // else map[v] = 1;
        map[v] = ++map[v] || 1;
    })
    const arr = Object.values(map).sort((a, b) => b - a);
    let sum = 0;
    let ans = 0;
    
    for(let i of arr){
        sum += i;
        ans ++;
        
        if(sum >= k) break;
    }
    return ans;
}
