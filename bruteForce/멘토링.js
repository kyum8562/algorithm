/*
멘토링
선생님은 멘토링 시스템(멘토, 멘티가 한짝)을 만들려고 한다.
만약 A학생=멘토, B학생=멘티라면 A학생은 B학생보다 M번의 테스트 등수가 매번 앞서야 한다.

멘토,멘티가 되는 짝을 만들 수 있는 경우가 총 몇가지인지 출력해라.
*/
function solution(arr){
    let answer = 0;
    let tmp = [] ;
    m = arr.length;
    n = arr[0].length;
    for(let l = 1 ; l <=n ; l++){
        for(let i = 1 ; i <= n ; i ++){
            let cnt = 0;
            for(let j = 0 ; j <m ; j++){
                let p1 = p2 = 0;
                for(let k = 0 ; k < n ; k ++){
                    if(arr[j][k] === l) p1 = k;
                    if(arr[j][k] === i) p2 = k;
                }
                if(p1 < p2) cnt++;
            }
            if(cnt === m){
                tmp.push([l, i]);
                answer++; 
            } 
        }
    }
    console.log(tmp);
    return answer;
}
console.log(solution([[3, 4, 1, 2],
                     [4, 3, 2, 1],
                     [3, 1, 4, 2]]));
// 기댓값 : 3
