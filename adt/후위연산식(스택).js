/*
후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
만약 3*(5+2)-9을 후위연산식으로 표현하면 352+*9- 이며 답은 12이다.

후위연산식 -> 중위연산식으로 변경시
stack에서 먼저나온수가 rt, 나중에 나온수가 lt로 지정하여 계산해야 한다.
*/
function solution(str){
    let answer = [];

    for(let i = 0 ; i < str.length ; i ++){
        if(str[i]/3) {
            answer.push(Number(str[i]));
        }
        else {
            let tmp1 = answer.pop();
            let tmp2 = answer.pop();
            if(str[i] === '+') answer.push(tmp2+tmp1);
            else if(str[i] === '*') answer.push(tmp2*tmp1);
            else if(str[i] === '/') answer.push(tmp2/tmp1);
            else if(str[i] === '-') answer.push(tmp2-tmp1);
        }
    }
    return answer;
}
console.log(solution('352+*9-'));