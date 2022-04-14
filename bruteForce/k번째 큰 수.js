/*
k번째 큰 수
1~100 사이의 숫자가 적힌 N장의 카드를 가지고 있다.
같은 숫자의 카드가 여러장 있을 수 있다.
이 중 3장을 뽑아 카드에 적힌 수를 합한 값을 기록하려고 한다.
3장을 뽑을 수 있는 모든 경우를 기록한다.
기록한 값 중 k 번쨰로 큰 수를 출력하는 프로그램을 작성해라

만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19 ... 이고
k 값이 3이라면 k번째 큰 값은 22이다.
*/
function solution(k, arr){
    let set = new Set();
    for(let i = 0 ; i < arr.length-2 ; i ++){
        for(let j = i+1; j < arr.length-1 ; j ++){
            for(let k = j+1; k < arr.length; k++){
                set.add(arr[i]+arr[j]+arr[k]);
            }
        }
    }
    let a = Array.from(set).sort((a,b) => b-a);
    
   
    return a[k-1];
}


console.log(solution(3, [13, 15, 34, 23, 45, 65, 33, 11, 26, 42]));
