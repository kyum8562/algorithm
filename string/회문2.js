function solution(str){
  str = str.toLowerCase().replace(/[^a-z]/g, '');
  if(str === str.split('').reverse().join('')) return true;
  else return false;
}


console.log(solution("found7, time: study; Yduts; emiU, 7Dnuof"));
console.log(solution("fouof7"));
