/*
회의실 배정
한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대해
회의실 사용 사용표를 만들려고 한다. 각 회의에 대해 시작시간, 끝시간
이 주어져있고, 각 회의가 겹치지 않게 하면서
최대 사용할 수 있는 회의 수를 구해라
*/
function solution(arr){
    let answer = 1;
    arr.sort((a,b) => {
        if(a[1] === b[1]) return a[0] - b[0];
        else return a[1] - b[1];
    });
    console.log(arr);

    let 끝난시간 = arr[0][1];
    for(let i = 0 ; i < arr.length -1; i ++){
        // 시작시간이 종료시간보다 크거나 같다면
        if(끝난시간 <= arr[i+1][0]){
            // answer를 ++ 해준다.
            answer++;
            끝난시간 = arr[i+1][1];
        }
    }
    return answer;
}


console.log(solution([[1, 4], [2, 3], [3, 5], [4, 6], [5, 7]]));
// 기댓값 : 3
console.log(solution([[3, 3], [1, 3], [2, 3]]));
// 기댓값 : 1
