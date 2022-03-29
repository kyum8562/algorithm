/*
공통원소 구하기
A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 
오름차순으로 출력하는 프로그램을 작성하세요

투 포인터는 시간복잡도 O(m)이다.

*/

function solution(arr1, arr2){
    let answer = [];
    let p1=p2=0;
    let sortArr1 = arr1.sort((a,b) => a-b);
    let sortArr2 = arr2.sort((a,b) => a-b);
    console.log(`sortArr1 : ${sortArr1}`);
    console.log(`sortArr2 : ${sortArr2}`);

    while(p1 < sortArr1.length && p2 < sortArr2.length){
        if(sortArr1[p1] === sortArr2[p2]){
            answer.push(sortArr1[p1++]);
            p2++;
        }
        else if(sortArr1[p1] < arr2[p2]) p1++;
        else p2++;

    }
    return answer;
}
console.log(solution([1, 3, 9, 5, 2], [3, 2, 5, 7, 8]))