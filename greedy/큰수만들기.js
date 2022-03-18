//큰수만들기
//어떤 수에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 수 구하기
//가장 큰 수를 문자열 형태로 리턴
function solution(number, k) {
    let answer = '';
    const stack = [];
    stack.push(parseInt(number[0]));
    
    for(var i = 1 ; i < number.length ; i ++){
        while(k>0 && parseInt(stack[stack.length-1]) < parseInt(number[i])){
            stack.pop();
            k--;
        }
            stack.push(parseInt(number[i]));
            
    }
    stack.splice(stack.length-k, k);
    answer = stack.join("")
    return answer;
}

console.log(solution("1924", 2));
console.log(solution("1231234", 3));
console.log(solution("4177252841", 4));
