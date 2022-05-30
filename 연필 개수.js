function solution(num){
  return Math.floor(num/12) + ((num%12)? 1: 0);
}


console.log(solution(25));
