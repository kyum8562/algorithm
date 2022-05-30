function solution(arr){
  // (1)
  // let answer = 0;
  // let min = 10000;
  // for(let i = 0 ; i < arr.length; i ++){
  //   if( arr[i] < min) min = arr[i];
  // }
  // return min;

  // (2) - 내장함수
  let answer = Math.min(...arr);
  return answer;
}


console.log(solution([5, 3, 7, 11, 2, 15, 17]));
