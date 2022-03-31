/*
쇠막대기
레이저는 여는 괄호와 닫는 괄호의 인접한 쌍으로 표현된다.
또한 모든 ()는 반드시 레이저를 표현한다.
쇠막대기의 왼쪽 끝은 여는 괄호로 오른쪽 끝은 닫힌 괄호로 표현된다.
*/
function solution(str){
    let answer = 0;
    let stack = [];
    for(let i = 0 ; i < str.length ; i ++){
        // str[i]이 여는괄호라면 stack에 푸시
        if(str[i] === '(') stack.push(str[i]);
        else{
            // str[i]이 닫는괄호이고, str[i-1]이 여는괄호라면 -> 인접한 쌍이라면 팝해준다.
            stack.pop();
            if(str[i-1] === '(') answer += stack.length;
            // 인접한 쌍이 아니라면 -> 쇠막대기의 끝이 위치해야 하는 곳
            else answer += 1;
        }
        console.log(stack, answer);
    }
    return answer;
}
console.log(solution('()(((()())(())()))(())'));