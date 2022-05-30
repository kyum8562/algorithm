/*
실패율 : https://programmers.co.kr/learn/courses/30/lessons/42889
*/

function solution(n, stage){
    let answer = [];
    let people = stage.length;
    for(let i = 1; i < n+1; i++){
        let tmp = stage.filter(n => n === i).length;
        answer.push([i, tmp/people]);
        people -= tmp;
    }
    answer = answer.sort((a,b) => b[1] - a[1]);
    return answer.map( a => a[0]);

}


console.log(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]));
