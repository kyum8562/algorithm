function solution(answers){
    let answer = [];
    const man1 = [1,2,3,4,5];
    const man2 = [2,1,2,3,2,4,2,5];
    const man3 = [3,3,1,1,2,2,4,4,5,5];
    let man1Correct = answers.filter((val,idx) => val === man1[idx%man1.length]).length;
    let man2Correct = answers.filter((val,idx) => val === man2[idx%man2.length]).length;
    let man3Correct = answers.filter((val,idx) => val === man3[idx%man3.length]).length;
    const max = Math.max(man1Correct, man2Correct, man3Correct);
    if(man1Correct === max) answer.push(1);
    if(man2Correct === max) answer.push(2);
    if(man3Correct === max) answer.push(3);
    
    return answer;
}

console.log(solution([1,2,3,4,5]));
console.log(solution([1,3,2,4,2]));
