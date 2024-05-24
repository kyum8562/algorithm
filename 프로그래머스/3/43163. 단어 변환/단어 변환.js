let arr, v, tgt, N, ans = 1 << 30;
function solution(begin, target, words) {
    arr = words;
    tgt = target;
    N  = words.length;
    
    v = [];
    
    for(let i = 0 ; i < N ; i ++)
        v[i] = false;
    
    dfs(begin, 0);
    
    return (ans == 1 << 30) ? 0 : ans;
}

function dfs(s, cnt){
    if(s == tgt){
        ans = Math.min(ans, cnt);
        return;
    }
    
    for(let i = 0 ; i < N ; i ++){
        if(!isChangePossible(s, i) || v[i]) continue;
        
        v[i] = true;
        dfs(arr[i], cnt+1);
        v[i] = false;
    }
}

function isChangePossible(s, i){
    let cnt = 0;
    let tmp = arr[i];
    let size = s.length;
    
    for(let i = 0 ; i < size ; i ++)
        if(s[i] !== tmp[i]) cnt ++;
    
    return (cnt == 1) ? true : false;
}