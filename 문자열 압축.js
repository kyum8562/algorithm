// 입력받은 문자열이 같은 문자가 연속적으로 올경우 
// 반복되는 문자 바로 오른쪽에 반복횟수를 표기하여 출력해라
function solution(str){
  let answer = "";
  let s = "";
  let cnt = 1;
  for(let i = 0 ; i < str.length; i ++){
    // 이전 값과 같으면
    if(s === str[i]) cnt ++;
    // 이전 값과 다르면
    else{
      if(cnt >= 2){
        answer += cnt;
        cnt = 1;
      }
      answer += str[i];
    }
    s = str[i];
  }
  return answer;
}


console.log(solution("KKHSSSSSSSE"));
