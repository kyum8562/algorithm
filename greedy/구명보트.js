// 구명보트
// people값은 사람마다의 몸무게이며
// limit는 구명보트 1개당 싣을수 있는 중량이다
// 모든사람을 태울 수 있는 최소 구명보트 개수를 구해라
// 단 구명보트는 작아서 최대 2명만 탈수있다
function solution(people, limit) {
    let answer = 0;
    people.sort((a,b) => b-a);
    let p1 = 0;
    let p2 = people.length -1;
    while(p1 < p2){
        if(limit >= people[p1] + people[p2] ){
            p1 ++;
            p2 --;
        }
        else{
            p1++;
        }
        answer ++;
        
    }
    if(p1 == p2) answer ++;
    return answer;
}

console.log(solution([70, 50, 80, 50], 100));
console.log(solution([70, 80, 50], 100));