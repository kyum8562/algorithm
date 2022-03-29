/*
연속 부분수열1
N개의 수로 이루어진 수열이 주어집니다.
이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요
만약 m=6이고 수열이 다음과 같다면
1 2 1 3 1 1 1 2 합이 6이 되는 연속 부분수열은 
{2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지이다.
*/
function solution(m, arr){
    let answer= 0;
    let p1 = p2 =0;
    let sum = arr[p1];
    while(p2 !== arr.length - 1){
        if(sum === m){
            answer++;
            sum -= arr[p1++];
        }
        else if(sum < m){
            sum += arr[++p2];
        }
        else if(sum > m){
            sum -= arr[p1++];
        }
    }
    

    return answer;
}
console.log(solution(6, [1, 2, 1, 3, 1, 1, 1, 2]));
