// 대소문자 구분없이 회문비교
function solution(str){
  let answer = true;
  let str1 = str.toLowerCase();
  let len = Math.floor(str.length/2);
  // (1)
  // for(let i =0 ; i < len; i ++){
  //   if( str1[i] !== str1[str.length -1 -i]) return false;
  // }

  // (2)
  // if(str1.split(''))
  if(str1.split('').reverse().join('') !== str1) return false;
  else true;

  return answer;
}


console.log(solution('good'));
