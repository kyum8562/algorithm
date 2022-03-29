/*
연속 부분수열2
N개의 수로 이루어진 수열이 주어집니다.
이 수열에서 연속부분수열의 합이 특정숫자 M이하가 되는 경우가 몇번 있는지
구하는 프로그램을 작성하세요,
만약 M=5이고 수열이 [1, 3, 1, 2, 3]이라면
합이 5이하가 되는 연속 부분수열 개수는 10개이다.

투 포인터는 시간복잡도 O(m)이다.

*/
function solution(m, arr){
    // (1)
    // let answer= 0;
    // let p1 = 0
    // let p2 = 1;
    // let sum = arr[p1] + arr[p2];
    // for(let i = 0 ; i < arr.length ; i ++){
    //     if(arr[i] <= m) answer++;
    // }
    // while(p1 !== p2){
    //     if(sum === m){
    //         answer++;
    //         sum -= arr[p1];
    //         p1++;
    //     }
    //     else if(sum < m){
    //         answer++;
    //         p2++;
    //         sum += arr[p2];
    //     }
    //     else if(sum > m){
    //         sum -= arr[p1];
    //         p1++;
    //     }
    // }

    // (2)
    let answer = 0 ;
    let lt = 0 ;
    let sum = 0;
    for(let rt = 0 ; rt < arr.length ; rt++){
        sum += arr[rt];
        while(sum > m){
            sum -= arr[lt++];
        }
        answer += (rt-lt+1);
    }
    return answer;
}
console.log(solution(5, [1, 3, 1, 2, 3]));
