let N, T, ans = 0;
let arr, choice;
function solution(numbers, target) {
    N = numbers.length;
    choice = new Array(N);
    arr = numbers;
    T = target;
    
    for(let i = 0 ; i < N ; i ++)
        choice[i] = false;
    
    comb(0, 0);
    
    return ans;
}
function comb(depth){
    if(depth == N){
        let sum = 0;
        
        for(let i = 0 ; i < N ; i ++){
            sum += arr[i];
            if(!choice[i]) sum *= -1;
        }
        
        if(sum == T) ans++;
        
        return;
    }
    
    choice[depth] = true;
    comb(depth+1);
    
    choice[depth] = false;
    comb(depth+1);
}