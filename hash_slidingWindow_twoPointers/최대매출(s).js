/*
최대 매출
현수의 아빠는 제과점을 운영한다. 현수 아빠는 현수에게 N일동안의 매출기록을 주고
연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했다.
만약 N=10이라면, 10일간의 매출기록은 다음과 같다. [12, 15, 11, 20, 25, 10, 20, 19, 13, 15]
이 때 K=3이라면, 연속된 3일간의 최대 매출액은 11+20+25 = 56만원이다.

슬라이딩 윈도우는 O(N)이다.
*/
function solution(k, arr){
    let answer = sum = 0;
    for(let i = 0 ; i < k ; i ++) sum += arr[i];
    answer = sum;
    for(let i = k ; i < arr.length ; i ++){
        sum += (arr[i] - arr[i-k]);
        if(answer < sum) answer = sum;
    }
    
    return answer;
}
console.log(solution(3, [12, 15, 11, 20, 25, 10, 20, 19, 13, 15]));