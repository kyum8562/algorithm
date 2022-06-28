// 각 행의 합, 각 열의 합, 격자 좌우 대각선의 합 중 가장 큰 합을 출력해라
function solution(arr){
  let row = 0;
  let col = 0;
  let sumDiagonal1 = 0;
  let sumDiagonal2 = 0;
  for(let i = 0; i < arr.length ; i ++){
    let sumRow = 0;
    let sumCol = 0;

    for(let j = 0; j < arr.length ; j ++){
      sumRow += arr[i][j];
      sumCol += arr[j][i];
    }
    if(sumRow > row) row = sumRow;
    if(sumCol > col) col = sumCol;
    sumDiagonal1 += arr[i][i];
    sumDiagonal2 += arr[i][arr.length-1-i];
  }
  return Math.max(row, col, sumDiagonal1, sumDiagonal2);

}


console.log(solution([[10, 13, 10, 12, 15],
                     [12, 39, 30, 23, 11],
                     [11, 25, 50, 53, 15],
                     [19, 27, 29, 37, 27],
                     [19, 13, 30, 13, 19]]));
