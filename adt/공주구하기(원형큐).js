/*
공주구하기
n명의 사람이 주어지고 나이를 기준으로 오름차순 시계방향으로 둥글게 앉는다.
그리고 첫번째 사람부터 1부터 차례로 외치는데, k를 말하는 사람은 제외가 된다.
마지막에 남은 사람은 몇번인가?
*/
function solution(n, k){
    // let queue = [];
    // for(let i = 1 ; i < n+1 ; i ++){
    //     queue.push(i);
    // }
    let queue = Array.from({length:n}, (v, i) => i+1);
    while(queue.length !== 1){
        let start = 0;
        while(start < k-1){
            queue.push(queue.shift());
            start++;
        }
        console.log(queue.shift());
 
    }

    return queue;
}

console.log(solution(8, 3));
