function solution(n,a,b)
{
    let stage = 1;
    let arr = [];
    for(let i = 1 ; i <= n ; i ++) arr.push(i); 
    while(n > 2){
        let arr2 = [];
        
        for(let i = 0 ; i < n ; i += 2){
            if(arr[i] == a && arr[i+1] == b || arr[i] == b && arr[i+1] == a) return stage;
            
            if(arr[i] == a || arr[i] == b) arr2.push(arr[i]);
            else if(arr[i+1] == a || arr[i+1] == b) arr2.push(arr[i+1]);
            else arr2.push(arr[i]);
        }
        n /= 2;
        stage++;
        arr = arr2;
    }

    return stage;
}