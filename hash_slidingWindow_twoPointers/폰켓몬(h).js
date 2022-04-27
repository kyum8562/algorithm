function solution(arr){
    let arrLen = arr.length/2;
    // (1) using hash-Map
    let hash = new Map();
    for(let i = 0 ; i < arr.length ; i ++){
        hash.set(arr[i]);
    }
    return arrLen > hash.size?  hash.size : arrLen;

    // (2) using Set
    // let set = new Set(arr);
    // return arrLen > set.size?  set.size : arrLen;


}

console.log(solution([3,3,3,2,2,4,5,7]));