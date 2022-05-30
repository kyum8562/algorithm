/*
일곱난쟁이
원래 7명 키의 합이 100이었는데 몰래 두 명이 추가로 들어왔다
원래의 일곱 난쟁이의 키를 입력 순으로 출력해라
*/
function solution(arr){
  let answer = [];
  let target = arr.reduce((acc, i) => {return acc+i}, 0) - 100;
  let a = 0;
  let b = 0;
  for(let i = 0 ; i < arr.length -1; i++){
    for(let j = i+1 ; j < arr.length; j++){
      if(arr[i] + arr[j] == target){
        // a = i;
        // b = j;
        arr.splice(i, 1);
        arr.splice(j, 1);
      }
    }
  }
  // answer = arr.filter((v, i) => {if(!(i == a || i == b)) return v})
  return arr;
} 


console.log(solution([20, 7, 23, 19, 10, 15, 25, 8, 13]));
