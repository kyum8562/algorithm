// 자동차 1의 자리 === 날짜의 1의자리  -> 운행금지
function solution(n, arr){
  let answer = 0;
  for(let i = 0 ; i < arr.length ; i ++){
    let a = arr[i]%10;
    if(n == a) answer++;
  }
  return answer;
}

console.log(solution(3, [25, 23, 11, 47, 53, 17, 33]));

