// 이분탐색 -> O(logN)
function solution(target, arr){
    let sortArr = arr.sort((a,b) => a - b);
    console.log(sortArr);
    let pivot = Math.ceil(arr.length/2);
    let lt = 0, rt = arr.length -1;
    for(let i = 0 ; i < Math.sqrt(sortArr.length); i ++){
        if(sortArr[pivot] > target) rt = pivot;
        else if(sortArr[pivot] === target) return pivot+1;
        else lt = pivot;

        pivot = Math.ceil(rt-lt)/2;
    }

    return -1;
}


console.log(solution(32, [23, 87, 65, 12, 57, 32, 99, 81]));
