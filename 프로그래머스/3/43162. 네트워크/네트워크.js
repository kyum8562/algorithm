let N, arr, v;
function solution(n, map) {
    N = n;
    arr = map;
    let ans = 0;
    
    v = new Array(N);
    
    for(let i = 0 ; i < N ; i ++)
        v[i] = false;
    
    for(let i = 0 ; i < N ; i ++){
        if(v[i]) continue;
        
        ans ++;
        bfs(i);
    }
    
    return ans;
}

function bfs(s){
    let q = [];
    q.push(s);
    v[s] = true;
    
    while(q.length > 0){
        let cur = q.shift();
        
        for(let next = 0 ; next < N ; next ++){
            // 간선이 없거나, 방문했다면 => pass
            if(arr[cur][next] == 0 || v[next]) continue;
            
            v[next] = true;
            q.push(next);
        }
    }
}