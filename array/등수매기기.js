function solution(arr){
  let answer = [1, 1, 1, 1, 1];
  for(let i = 0 ; i < arr.length ; i++){
    for(let j = 0 ; j < arr.length ; j++){
      if(arr[j] > arr[i]) answer[i]++;
    }
  }

  return answer;
}


console.log(solution([87, 89, 92, 100, 76]));
console.log(solution([87, 92, 92, 92, 76])); // 4, 1, 1, 1, 5

