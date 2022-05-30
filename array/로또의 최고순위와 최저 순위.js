// https://programmers.co.kr/learn/courses/30/lessons/77484
function solution(lottos, win_nums){
    // let answer = [];
    // let cnt = lottos.filter(n => n === 0).length;
    // let zero = cnt;

    // for(let lotto of lottos){
    //     if(win_nums.includes(lotto)) cnt ++;
    // }
    // for(let i = 0 ; i < 2 ; i ++){
    //     if(i ===1) cnt -= zero;
        
    //     if(cnt <= 1) answer.push(6);
    //     else if(cnt ===2) answer.push(5);
    //     else if(cnt ===3) answer.push(4);
    //     else if(cnt ===4) answer.push(3);
    //     else if(cnt ===5) answer.push(2);
    //     else if(cnt ===6) answer.push(1);
    // }

    // return answer;

    const rank = [6, 6, 5, 4, 3, 2, 1];

    let minCnt = lottos.filter(v => win_nums.includes(v)).length;
    let zeroCnt = lottos.filter(v => !v).length;

    const maxCnt = minCnt + zeroCnt;

    return [rank[maxCnt], rank[minCnt]];
}

console.log(solution([44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19]));