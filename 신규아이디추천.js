/*
새로 가입하는 유저들이 카카오 아이디 규칙에 맞지 않는 아이디를 입력했을 때, 
입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천해주는 프로그램을 개발하는 것입니다.

다음은 카카오 아이디의 규칙입니다.
- 아이디의 길이는 3자 이상 15자 이하여야 합니다.
- 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
- 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.

"네오"는 다음과 같이 7단계의 순차적인 처리 과정을 통해 신규 유저가 입력한 아이디가 카카오 아이디 규칙에 맞는 지 검사하고 규칙에 맞지 않은 경우 규칙에 맞는 새로운 아이디를 추천해 주려고 합니다.
신규 유저가 입력한 아이디가 new_id 라고 한다면,

1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

신규 유저가 입력한 아이디를 나타내는 new_id가 매개변수로 주어질 때, 
"네오"가 설계한 7단계의 처리 과정을 거친 후의 추천 아이디를 
return 하도록 solution 함수를 완성해 주세요.
*/

function solution(new_id){
    // 1단계
    let new_id_Lower = new_id.toLowerCase();
    let answer = [];
    let a = 0;
    for(let i = 0 ; i <new_id.length ; i ++){
        // 2단계
        let tmp = new_id_Lower[i].charCodeAt();
        if(!(tmp === 46 ||
             tmp === 45 ||
             tmp === 95 ||
             tmp >= 97 &&
             tmp <= 122 ||
             tmp >= 48 &&
             tmp <= 57)){
                answer.push(i);
                a++;
             }
    }
    let right = new_id_Lower.split("");
    if(answer.length) right.splice(answer[0],1);
    for(let i = 1 ; i < answer.length; i ++){
        right.splice(answer[i]-1,1);
    }
    // 3단계
    for(let i = 0 ; i < right.length -1; i++){
        if(right[i] === '.' && right[i+1] === '.' ){
            right.splice(answer[i],1);
            i -= 1;
        }
    }
    console.log(right)
    console.log(new_id_Lower.length, a, right.length)
//    return a;
}


console.log(solution("...!@BaT#*..y.abcdefghijklm"));
// console.log(solution("z-+.^."));
// console.log(solution("=.="));
// console.log(solution("123_.def"));
// console.log(solution("abcdefghijklmn.p"));
