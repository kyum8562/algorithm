/*
좌표정렬(2차원 배열 정렬)
N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로
정렬하는 프로그램을 작성해라. 
먼저 x값에 의해서 정렬하고, x값이 같을경우 y값에 의해 정렬해라.
*/
function solution(arr){
    arr.sort((a,b) => {
        if(a[0] === b[0]) return a[1] - b[1];
        else return a[0] - b[0];
    });
    
    return arr;
}


console.log(solution([[2, 7], [1, 3], [1, 2], [2, 5], [3, 6]]));
