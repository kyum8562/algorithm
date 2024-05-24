let N, v, arr, ans = [];
function solution(tickets) {
    arr = tickets;
    N = tickets.length;
    v = [];
    
    for(let i = 0 ; i < N ; i ++)
        v[i] = false;
    
    dfs("ICN", "ICN", 0);
    
    return ans.sort()[0].split(" ");
}

function dfs(cur, route, cnt){
    if(cnt == N){
        ans.push(route);
        return;
    }
    
    for(let i = 0 ; i < N ; i ++){
        if(arr[i][0] != cur || v[i]) continue;
        
        v[i] = true;
        dfs(arr[i][1], route + " " + arr[i][1], cnt+1);
        v[i] = false;
    }
}