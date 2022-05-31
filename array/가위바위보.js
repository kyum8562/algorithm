// 가위 :1, 바위 :2, 보 :3
function solution(arr1, arr2){
  let answer = "";
  for(let i = 0 ; i < arr1.length; i ++){
    if(arr1[i] === 3 && arr2[i] === 1) answer += 'B' + " ";
    else if(arr1[i] === 1 && arr2[i] === 3) answer += 'A' + " ";
    else if(arr1[i] > arr2[i]) answer += 'A' + " ";
    else if(arr1[i] < arr2[i]) answer += 'B' + " ";
    else answer += 'D' + " ";
  }
  return answer;
}


console.log(solution([2, 3, 3, 1, 3], [1, 1, 2, 2, 3]));
2 > 1
3 > 2
1 > 3