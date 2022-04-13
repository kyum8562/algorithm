function solution(n, stack){
        let arr = Array.from({length:n}, () => 0);
        while(stack.length !== 0){
            let a = stack.shift();
            let idx = arr.indexOf(a);

            // Cache Hit
            if(idx >0){
                let tmp = arr[idx], j;
                for(j = idx-1 ; j >= 0 ; j --){
                    if(1==1) arr[j+1] = arr[j];
                    else break;
                }
                arr[j+1] = tmp;
            }
            // Cache Miss
            else{
                arr.unshift(a);
                arr.pop();
            }
            console.log(arr);
        }
    
    return arr;
}
 

// console.log(solution([5, 11, 7, 23, 15]));
console.log(solution(5, [1, 2, 3, 2, 6, 2, 3, 5, 7]));


/*
push/shift/unshift를 사용하지 못한다면
=> 
stack.forEach((x) => {
    var idx = arr.indexOf(x);
    // [동일코드] for(let i = 0 ; i < n ; i ++) if(arr[i] === x) idx = i;

    // cache miss일 때
    if(idx < 0){
        for(let i = n ; i >= 1 ; i --){
            arr[i] = arr[i-1];
        }
        arr[0] = x;
    }
    else{
        // cache hit일 때
        for(let j = idx ; j >= 1 ; j --){
                arr[j] = arr[j-1];
        }
        arr[0] = x;
    }
});
*/