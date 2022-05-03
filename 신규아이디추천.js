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
    // // 1단계 대문자를 소문자로 변환
    // let new_id_Lower = new_id.toLowerCase();
    // // 소문자로 변경된 문자열을 배열로 치환
    // let answer = new_id_Lower.split('');
    // for(let i = 0 ; i < answer.length ; i ++){
    //     // 4단계(1) : 마침표(.)가 처음에 위치한다면 제거합니다.
    //     while(i === 0 && answer[0] === '.'){
    //         answer.shift();
    //     }
    //     // 4단계(2) : 마침표(.)가 마지막에 위치한다면 제거합니다.
    //     while(answer[answer.length-1] === '.'){
    //         answer.pop();
    //     }
    //     if(answer.length >= 1){
    //         // 2단계 : 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    //         let tmp = answer[i].charCodeAt();
    //         if(!(tmp === 46 || // '.'
    //                 tmp === 45 || // '-'
    //                 tmp === 95 || // '_'
    //                 tmp >= 97 && // 소문자
    //                 tmp <= 122 ||
    //                 tmp >= 48 && // 숫자
    //                 tmp <= 57))
    //             {
    //                 answer[i] = '';
    //             }
    
    //         // 3단계 : 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    //         if(answer[i] ==='.' && answer[i+1] === '.'){
    //             answer[i] = '';
    //             i = -1;
    //         }
    //     }
    // }
    
    // // 빈공간 제거 및 배열 -> 문자열로 변환
    // answer = answer.filter((val, idx) => answer[idx] !== '').join('');

    // while(answer[answer.length-1] === '.'){
    //     answer = answer.slice(0, answer.length-1);
    // }

    // // 5단계 빈 문자열이라면, new_id에 "a"를 대입합니다.
    // if(answer.length === 0){
    //     answer = 'a';
    // }
    // // 6단계
    // while(answer.length > 15){
    //     answer = answer.slice(0, 15);

    //     // 마침표(.)가 마지막에 위치한다면 제거합니다.
    //     while(answer[answer.length-1] === '.'){
    //         answer = answer.slice(0, answer.length-1);
    //     }
    // }
    // if(answer.length <= 2){
    //     if(answer.length === 1) answer += answer[answer.length-1].repeat(2);
    //     else if(answer.length === 2) answer += answer[answer.length-1].repeat(1);
    // }
    // console.log("");
    // console.log(`before id : ${new_id}`);
    // console.log(`before id.length : ${new_id.length}`);
    // console.log(`after id : ${answer}`);
    // console.log(`after id.length : ${answer.length}`);

    // return answer;
}

function solution1(new_id){
    const answer = new_id

    .toLowerCase() // 1
    .replace(/[^\w-_.]/g, '') // 2
    .replace(/\.+/g, '.') // 3
    .replace(/^\.|\.$/g, '') // 4
    .replace(/^$/, 'a') // 5
    .slice(0, 15).replace(/\.$/, ''); // 6
    
    const len = answer.length;

    return len > 2 ? 
        answer :
        answer + answer.charAt(len - 1).repeat(3 - len);
}

// console.log(solution("...!@BaT#*..y.abcdefghijklm"));
// console.log(solution("."));
console.log(solution1("==="));
// console.log(solution("z-+.^."));
// console.log(solution("=.="));
// console.log(solution("123_.def"));
// console.log(solution("abcdefghijklmn.p")); //abcdefghijklmn
