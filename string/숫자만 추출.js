// 문자열에서 숫자만 추출하며, 첫 숫자가 0이면 0 제거
function solution(str){
  // str = parseInt(str.replace(/[^0-9]/g, ''));
  let s = '';
  // for(let i = 0 ; i < str.length ; i ++){
  //   if(parseInt(str[i]) >= 0 && parseInt(str[i]) <= 9)
  //     s += str[i];

  // }
  for(let x of str){
    if(!isNaN(x)) s+= x;
  }
  return parseInt(s);
}


console.log(solution("g0en2T0s8eSoft"));
