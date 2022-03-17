// 체육복
function solution4(n, lost, reserve) {
    var answer = 0;
    let cnt = 0;
    const arr = new Array(n).fill(1);
    for(let i = 0; i < lost.length ; i ++){
        arr[lost[i]-1] -= 1; 
    }
    for(let i = 0; i < reserve.length ; i ++){
        arr[reserve[i]-1] += 1; 
    }
    // console.log(arr);
    
    for(let i = 0 ; i < arr.length ; i ++){
        // 체육복이 없는 인덱스
        if(arr[i] == 0){
            // 먼저 앞사람이 체육복이 2개인지 확인, 2개라면 나누어 줌
            if(arr[i-1] ==2){
                arr[i-1] = 1;
                arr[i] = 1;
            }
            // 앞사람x, 뒷사람이 체육복이 2개인지 확인, 2개라면 나누어 줌
            else if(arr[i+1] ==2){
                arr[i+1] = 1;
                arr[i] = 1;
            }
        } 
    }
    arr.map(a => {if(a >=1) cnt++;})
    
    return cnt;
}

console.log(solution4(5, [2,4], [1,3,5]));
console.log(solution4(5, [2,4], [3]));
console.log(solution4(3, [3], [1]));
console.log(solution4(7, [2, 3, 4], [1, 2, 3, 6]));



// function solution(n, lost, reserve) {      
//     return n - lost.filter(a => {
//         const b = reserve.find(r => Math.abs(r-a) <= 1)
//         if(!b) return true
//         reserve = reserve.filter(r => r !== b)
//     }).length
// }


//(2)

// function solution(n, lost, reserve) {
//     const students = {};
//     let answer = 0;
//     for(let i = 1; i <= n; i++){
//         students[i] = 1;
//     }
//     lost.forEach(number => students[number] -= 1);
//     reserve.forEach(number => students[number] += 1);

//     for(let i = 1; i <= n; i++){
//         if(students[i] === 2 && students[i-1] === 0){
//                 students[i-1]++;
//                 students[i]--;
//         } else if(students[i] === 2 && students[i+1] === 0){
//                 students[i+1]++;
//                 students[i]--;
//         }
//     }
//     for(let key in students){
//         if(students[key] >= 1){
//             answer++;
//         }
//     }
//     return answer;
// }
