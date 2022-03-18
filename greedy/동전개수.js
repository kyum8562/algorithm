// 동전개수
// final(최종값)에 맞추기 위해
// 최소의 동전을 사용해라
function solution(coin, final) {
    var answer = 0;
    var sortedArr = coin.sort((a,b) => b-a);

    var i = 0;
    while(i < final){
        if(sortedArr[i] < final){
            final -= sortedArr[i]
            answer ++;
        }
        else{
            i++;
        }
        
    }
    return answer;
}

console.log(solution([10, 100, 500], 710));