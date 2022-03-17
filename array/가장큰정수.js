// //가장 큰 정수(numbers에 있는 수를 모두 조합해서 만들 수 있는 가장 큰 수 출력)
function solution2(numbers){
    // map을 이용해서 배열내의 숫자 -> 문자로 변경
    var answer = numbers.map(c => c + "").
    // sort에 따라 내림차순 비교정렬 및 join을 통해 문자열 합산
    sort((a,b) => (b+a) - (a+b)).join('');
    
    // 내림차순 정렬된 값이 '0'이 아니면 answer 호출
    return answer[0] === '0' ? '0' : answer;
}
function init(){
    const s2 = solution2([6, 10, 2]);
    console.log(s2);
}

init();



