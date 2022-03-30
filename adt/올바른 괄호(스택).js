/*
올바른 괄호
괄호가 입력되면 올바른 괄호이면 "YES", 그렇지 않으면 "NO"를 출력해라
(())() -> "YES"
(()())) -> "NO"
*/
function solution(str){
    // let answer = 0;
    let stack = [];
    for(let x = 0 ; x < str.length ; x++){
        if(str[x] === '('){
            stack.push(str[x]);
        }
        else{
            if(stack.length === 0) return "NO";
            stack.pop();
        }
        // console.log(stack);
    }
    if(stack.length > 0) return "NO";
    return "YES";
}

console.log(solution('((()(()))(())'));
