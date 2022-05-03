/*
예산
arr에는 물품을 구매하는데 필요한 금액들이 담겨져 있으며
budget에는 현재 남은 예산이다.

반드시 budget을 모두 사용해야 한다면,
최대 몇 개의 부서에 물품을 지원할 수 있는지 return 해라

*/
function solution(arr, budget){
    let answer = 0;
    arr = arr.sort((a,b) => a-b);
    for(x of arr){
        if(budget >= x){
            budget -= x;
            answer ++;
        }
    }
    return answer;
}


console.log(solution([1,3,2,5,4], 9));
console.log(solution([2,2,3,3], 10));
