/*
괄호문자제거
입력된 문자열에서 소괄호 () 사이에 존재하는 모든 문자를 제거하고
남은 문자만 출력하는 프로그램을 작성하세요
※문자열의 길이는 100을 넘지 않는다
*/
function solution(str){
    let stack = [];
    for(let i = 0 ; i < str.length ; i ++){
        if(str[i] === ')' ){
            while(stack.pop() !== '(');
        }
        else stack.push(str[i]);
    }

    return stack.join('');
}

console.log(solution('(A(BC)D)EF(G(H)(IJ)K)LM(N)'));
