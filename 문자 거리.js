// 문자열(s)와 문자(t)는 모두 소문자로 이루어져있다.
// 문자열의 각 문자는 t와 얼마나 떨어져있는지 파악해라

// 1 0 1 2 3 0 1 2 3 4 0 >> 왼쪽에서 탐색
// 오른쪽에서부터 탐색하여 해당 값이 기존 숫자보다 적으면 값 대체
function solution(s, t){
  let answer = [];
  let cnt = 0;
  // 왼쪽에서 탐색
  for(let i = 0 ; i < s.length; i ++){
    if(s[i] !== t){
      answer[i] = ++cnt;
    }
    else{
      answer[i] = 0;
      cnt = 0;
    }
  }


  cnt = 0;
  // 오른쪽에서 탐색
  for(let i = s.length-1; i >= 0; i --){
    if(s[i] !== t){
      let tmp = ++cnt;
      if(answer[i] > tmp) answer[i] = tmp;
    }
    else{
      answer[i] = 0;
      cnt = 0;
    }
  }
  return answer;
}


console.log(solution("teachermode", "e"));

