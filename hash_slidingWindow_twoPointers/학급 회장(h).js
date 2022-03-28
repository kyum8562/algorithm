/* 
학급회장
학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다
투표 용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며
선생님은 그 기호를 발표하고 있습니다.
선생님의 발표가 끝난 후 어떤 기호의 후보가 학급회장이 되어쓴지 프로그램을 작성하세요.
반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.
*/
function solution(str) {
    let answer = 0;
    let hash = new Map();
    for(let i = 0 ; i < str.length ; i ++){
        if(hash.has(str[i])){
            hash.set(str[i],
                hash.get(str[i])+1)
        }
        else{
            hash.set(str[i], 1);
        }
    }
    let max = Number.MIN_SAFE_INTEGER;
    for(let [key, val] of hash){
        if(val > max){
            max = val;
            answer = key;
        }
    }

    return answer;
}


console.log(solution('BACBACCACCBDEDE'))