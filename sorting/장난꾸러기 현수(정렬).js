/*
장난꾸러기 현수
현수네 반에는 N명의 학생이 있다.
선생님은 반 학생들에게 반 번호를 정해주기위해 운동장에
반 학생들을 키가 가장 작은 학생부터 일렬로 세웠다.

현수는 짝궁보다 키가 크다. 그런데 현수는 앞 번호를 받고싶어 짝궁과 자리를 바꾸었다.
선생님은 이 사실을 모르고 학생들에게 서있는 순서대로 번호를 부여했다.

현수와 짝궁이 자리를 바꾼 반 학생들을 일렬로 서있는 키 정보가
주어졌을 때 현수가 받은 번호, 짝궁이 받은 번호를 차례로 출력해라.
*/
function solution(arr){
    let sortArr = arr.slice();
    let answer = [];
    for(let i = 0 ; i < arr.length; i ++){
        for(let j = 1 ; j < arr.length-i ; j++){
            if(sortArr[j-1] > sortArr[j]){
                [sortArr[j-1], sortArr[j]] = [sortArr[j], sortArr[j-1]];
            }
        }
    }
    for(let i = 0 ; i < sortArr.length ; i ++){
        if(sortArr[i] !== arr[i]) answer.push(i+1);
    }
    return answer;
}


console.log(solution([120, 125, 152, 130, 135, 135, 143, 127, 160]));
// 기댓값 : 3 8
// console.log(solution([120, 130, 150, 150, 130, 150]));
// 기댓값 : 3 5