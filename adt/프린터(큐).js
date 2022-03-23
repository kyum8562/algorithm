function solution(priorities, location) {
    let answer = 0;
    while(priorities.length){
        if(priorities[0] < Math.max(... priorities)){
            priorities.push(priorities.shift());
            if (--location < 0) location = priorities.length - 1;

            // if(location > 0) return location;
            // else if(location == 0) return 1;
            // else return (priorities.length +1 + location);
        }
        else{
            answer ++;
            if (--location < 0) return answer;
            priorities.shift();
        }
    }
}
// function solution(priorities, location) {
//     /*
//         1. 최댓값을 구한다
//         2. 최댓값이 아니라면 shift, push로 뒤로 보낸다
//         3. location은 1씩 감소한다
//             0일 경우에는 length - 1
//         4. 최댓값일 경우에 shift
//             만약 location이 0이면 count 리턴
//             아니라면 count 증가 후 다시 최댓값을 구한 뒤 계속 진행
//     */
//     let answer = 1,
//         i = 0;
//     let max = Math.max(...priorities);
//     while (priorities.length !== 0) {
//         if (priorities[i] === max) {
//             if (location === 0) {
//                 return answer;
//             }
//             priorities.shift();
//             answer += 1;
//             max = Math.max(...priorities);
//         } else {
//             priorities.push(priorities.shift());
//         }
//         if (location !== 0) {
//             location -= 1;
//         } else {
//             location = priorities.length - 1;
//         }
//     }
//     return -1;
// }
// console.log(solution([2, 1, 3, 2],	2));
console.log(solution([1, 1, 9, 1, 1, 1],	0));    

