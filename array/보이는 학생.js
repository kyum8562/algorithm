function solution(arr){
  let answer = 0;
  let max = 0;
  for(let x of arr){
    if(x > max){
      answer++;
      max = x;
    }

  }
  return answer;
}

console.log(solution([130, 135, 148, 140, 145, 150, 150, 153]))