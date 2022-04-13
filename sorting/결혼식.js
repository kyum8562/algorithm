/*
결혼식
현수는 다음달에 결혼을 합니다.
결혼식 피로연을 장소를 빌려 3일간 쉬지 않고 하려고 합니다.
피로연에 참석하는 친구들 N명의 참석하는 시간 정보를 미리 요구했습니다.
이 정보를 바탕으로 피로연 장소에 동시에 존재하는 최대 인원수를
구하여 그 인원을 수용할 수 있는 장소를 빌리려고 합니다.

만약 한 친구가 오는 시간 13, 가는시간 15라고 한다면
이 친구는 13시 정각에 피로연 장에 존재하는 것이고 15시 정각에는 존재하지 않는다고 가정합니다.
*/

function solution(arr){
    let answer = 1;
    arr.sort((a,b) =>{
        if(a[1] === b[1]) return a[0] - b[0];
        else return a[1] - b[1];
    });

    for(let x of arr){
        x[1] -= 1;
    }
    console.log(arr);

    for(let x of arr){
        let tmp = x[1];
        let sum = 0;
        for(let i = 1 ; i < arr.length ; i ++){
            if(tmp >= arr[i][0] && tmp <= arr[i][1]) sum ++;
        }
        if(answer < sum) answer = sum;
    }
    return answer;
}


console.log(solution([[14, 18], [12, 15], [15, 20], [20, 30], [5, 14]]));
