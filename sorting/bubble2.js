/*
버블정렬 2 : 구글 인터뷰 문제
음의 정수는 앞쪽에 양의 정수는 뒷쪽에 있어야 한다.
또한 양의 정수와 음의 정수의 순서는 변함이 없어야 한다.

push를 이용하면 안된다.
*/
function solution(arr){
    for(var i = 0 ; i < arr.length-1 ; i ++){
        for(var j = 0 ; j < arr.length-i-1 ; j ++){
            if(arr[j]>0 && arr[j+1]<0) 
            [arr[j], arr[j+1]] = [arr[j+1], arr[j]];
 
        }
        console.log(i, j, arr);
    }

    return arr;
}


console.log(solution([1, 2, 3, -3, -2, 5, 6, -6]));
//기댓값 : -3 -2 -6 1 2 3 5 6