/*
두 배열 합치기
오름차순으로 정렬(nLogn)이 된 두 배열이 주어지면 
두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.

투 포인터는 시간복잡도 O(m)이다.
*/
function solution(arr1, arr2) {
    let answer = [];
    let p1 = p2 = 0;
    let allLength =  arr1.length + arr2.length;
    while(answer.length < allLength){
       if(arr1[p1] >arr2[p2]){
           if(p2 < arr2.length){
                answer.push(arr2[p2++]);
            }
       }
       else if(arr1[p1] < arr2[p2]){
            if(p1 < arr1.length){
                answer.push(arr1[p1++]);
            }
       }
       else{
           if(p1 < arr1.length){
            answer.push(arr1[p1++]);
           } 
           if(p2 < arr2.length){
            answer.push(arr2[p2++]);
           } 
       }
    }
    return answer;
}

console.log(solution([1, 3, 5], [2, 3, 6, 7, 9]));