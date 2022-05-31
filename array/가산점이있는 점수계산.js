function solution(arr){
  let answer = 0;
  let tmp = 0; // 가산점
  for(let x of arr){
    x === 1 ? tmp ++ : tmp =0;
    answer += tmp;
  }
  return answer;
}

console.log(solution([1, 0, 1, 1, 1, ,0, 0, 1, 1, 0]));