function solution(a, b, c){
  let arr = [a, b, c];
  let max = 0;
  for(let i = 0 ; i< arr.length;i++)
    if( max < arr[i]) max = arr[i] ;
  
  if( arr.reduce((i, j) => i + j, 0) > max*2) return true;
  else return false;
}


console.log(solution(6, 7, 11));
console.log(solution(13, 33, 17));



// 삼각형의 세 변에 대한 값을 각각 구하고
// 가장 큰 값 < 나머지 두변 이면 true
// 아니면 false