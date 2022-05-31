function solution(arr){
  // (1)
  // let answer = "";
  // for(let i = 0; i < str.length; i ++){
  //   if(i === str.indexOf(str[i])) answer += str[i];
  // }
  // return answer;

  // (2)
  // let answer = [];
  // for(let i = 0 ; i< arr.length; i++){
  //   if(i === arr.indexOf(arr[i])) answer.push(arr[i]);
  // }
  // return answer;

  // (3)
  let answer = arr.filter((v, i) => { return arr.indexOf(v) === i});
  // 동일 {if(arr.indexOf(v) === i) return true}
  return answer;

}


// console.log(solution("ksekkset")); // "kset"
console.log(solution(["good", "time", "good", "time", "student"])); // "kset"
