function solution(str) {
  let answer = '';
  // (1)
  // for(let x of str){
  //   (x == 'A')? answer += '#' : answer += x;
  // }

  // (2)
  answer = str.replace(/A/g, '#');
  return answer;
}


console.log(solution("BANANA"));
