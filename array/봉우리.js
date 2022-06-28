function solution(arr){
  let answer = 0;
  let len = arr.length;
  let dx = [-1, 0, 1, 0];
  let dy = [0, 1, 0, -1];

  for(let i = 0 ; i < len ; i ++){
    for(let j = 0 ; j < len ; j ++){
      let flag = true;
      for(let k = 0 ; k < dx.length; k++){
        let nx = i+dx[k];
        let ny = j+dy[k];
        if(nx >= 0 && nx < len && ny >= 0 && ny < len && arr[nx][ny] >= arr[i][j]){
          flag = false;
          break;
        }
      }
      if(flag) answer++;
    }
  }
  return answer;
}


console.log(solution([[5, 3, 7, 2, 3],
                     [3, 7, 1, 6, 1],
                     [7, 2, 5, 3, 4],
                     [4, 3, 6, 4, 1],
                     [8, 7, 3, 5, 2]]));
