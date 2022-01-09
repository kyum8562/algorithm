// Q1. 직사각형 별찍기
function q1() {
    // 표준 입력으로 두 개의 정수 a, b가 주어지고
    // 별(*) 문자를 이용해 가로의 길이가 a, 세로의 길이가 b인 직사각형 형태 출력

    const a = 5, b = 3; // a, b는 임의의 수
    var result = "";

    // while 반복문을 이용

    var i = 0;
    var j = 0;
    while (j < b) {
        while (i < a) {
            result += `*`;
            i = i + 1;
        }
        console.log(result);
        j = j + 1;
    }

    // while 변형

    // while(a-- > 0){
    //     result += `*`;
    // }

    // while(b-- > 0){
    //     console.log(result);
    // }


    // for 반복문을 이용

    // for(var k = 0; k<b; k++){
    //     result = "";
    //     for(var l = 0 ; l<a; l++){
    //         result += '*';
    //     }
    //     console.log(result);
    // }

    // repeat 활용

    // const row = '*'.repeat(a);
    // for(let i =0; i<b; i++){
    //     console.log(row);
    // }

    // repeat 변형1

    // const row = `'*'.repeat(a)\n`;
    // console.log(row.repeat(b));

    // repeat 변형2

    //console.log((('*').repeat(a)+ '\n').repeat(b))
}

// 별찍어서 트리 만들기
function tree() {
    var resultSpace = [" ", " ", " ", " ", " ", " ", " ", " ", " ", " "];
    var result = "";
    var a = 0;
    var b = 10;

    for (var i = 0; i < b; i++) {
        result += '*';
        resultSpace.pop();
        console.log(resultSpace.join('') + result);
        result += '*';
    }
}

// Q2. x만큼 간격이 있는 n개의 숫자
function q2(x, n) {
    // 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자
    // n개 지니는 리스트를 리턴해야 한다.
    // var x = 2, n = 5;

    // (1)
    // var tmp = x;
    // var answer = [];
    // for(var i = 0; i<n ; i++){
    //     answer.push(tmp);
    //     tmp = x + tmp;
    // }

    //(2)
    // return answer;
    return nNumbers(x, n);
    // expected output : [2, 4, 6, 8, 10]
}

// Q2의 2 번째 문제풀이
const nNumbers = (x, n) => {
    return Array.from({ length: n }, (v, index) => (index + 1) * x);
};

// Q3. 행렬의 덧셈
function q3() {
    // 2개의 행렬 arr1과 arr2를 입력받아(행과 열의 크기가 같아야 함)
    // 행렬 덧셈의 결과를 반환하는 함수 만들기
    var answer = [[]];
    var arr1 = ([[5, 2], [2, 3]]);
    var arr2 = [[3, 4], [5, 6]];

    // (1)
    // for(var i = 0 ; i < arr1.length; i++){
    //     var tmp = [];
    //     for(var j = 0 ; j < arr1[i].length; j++){
    //         tmp.push([arr1[i][j] + arr2[i][j]]);
    //     }
    //     answer.push(tmp);
    // }

    // (2)
    // for(var i = 0; i < arr1.length; i++){
    //     answer[i] = [];
    //     for(var j = 0; j < arr1[i].length; j++){
    //         answer[i].push(arr1[i][j] + arr2[i][j]);
    //     }
    // }

    answer = A.map((a, i) => a.map((b, j) => b + B[i][j]));

    // 리턴
    return answer;
}

// Q4. 전화번호 뒷 4자리를 제외한 나머지 숫자 전부 *로 마스킹
function q4() {
    var phone_number = '01033921234';

    // (1)
    var front_number = phone_number.slice(0, -4);
    var back_number = phone_number.slice(-4);
    var answer = "*".repeat(front_number.length) + back_number;

    // (2)
    var a1 = phone_number.replace(/\d(?=\d{4})/g, "*");

    // output
    console.log(answer);
    console.log(a1);
}

// Q5. 하샤드 수
function q5() {
    // 양의 정수 x가 하샤드 수가 되려면 x의 자릿수의 합으로 x가 나누어
    // 져야 한다. ex) 18은 자릿수 합이 9이고, 9로 나누어 떨어지므로 true

    var x = 18;
    var answer = '';

    // (1)
    // var n1 = x%10; //4
    // var n2 = parseInt((x%100 - n1)/10);//3 
    // var n3 = parseInt((x-n1-n2)%1000/100); // 200
    // var n4 = parseInt((x-n1-n2-n3)%10000/1000); // 1000
    // var n5 = parseInt((x-n1-n2-n3-n4)%100000/10000); // 1000
    // var n = n1 + n2 + n3 + n4 + n5;
    // if (x % n === 0){
    //     answer = true;
    // }
    // else{
    //     answer = false;
    // }
    // console.log(answer);

    // (2)
    // var sum = 0;
    // var arr = String(x).split('');
    // for (var i = 0; i < arr.length; i++){
    //     sum += arr[i];
    // }
    // return x % sum == 0 ? true : false;

    // (3)
    // var sum = 0;
    // var num = x;
    // do {
    //     sum += x%10;
    //     x = Math.floor(x/10);
    // }
    // while(x>0);
    // console.log(!(num%sum));

    // (4) recursion function
    // function recursionSol(x, i=0, sum=0){
    //     return String(x).length == i ? x%sum ==0 : recursionSol(x,i+1,sum+ String(x)[i]*1);
    // }
    // var result = recursionSol(18);
    // console.log(result);

    // (5)
    // return !(x % (x + "").split("").reduce((a, b) => +b + +a ));
}

// Q6. 평균 구하기
function q6() {
    // 정수를 담고있는 배열 arr의 평균값 리턴하기
    var answer = 0;
    var arr = [1, 2, 3, 4];

    // (1)
    // var sum = 0;
    // for(var i=0; i< arr.length; i++){
    //     sum += arr[i];
    // }

    // answer = sum/arr.length;
    // console.log(answer);

    // (2) reduce -1
    console.log(`평균값 : ${arr.reduce((a, b) => a + b) / arr.length}`)

    // (3) reduce -2
    var result = arr.reduce(function (a, b) { return a + b }) / arr.length;
    console.log(`평균값2 : ${result}`);
}

// Q7. 콜라츠 추측
function q7() {
    // 주어진 수가 1이 될때까지 다음 작업을 반복하면,
    // 모든 수를 1로 만들 수 있다는 추측
    // [작업]
    // 1-1. 입력된 수가 짝수라면 2로 나눈다.
    // 1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더한다.
    // 2. 결과로 나온 수에 같은 작업을 1이 될 떄 까지 반복한다.
    // [작업]의 횟수를 반환 하는 문제
    // [작업]을 500번 반복해도 1이 되지않는다면 -1 리턴

    var answer = 0;
    var x = 6;
    var cnt = 0;

    // (1)
    // while(x != 1){
    //     x%2 == 0 ? x = x/2 : x = x*3 +1
    //     cnt += 1;

    //     if(cnt == 500){
    //         return -1;
    //     }
    // }
    // answer = cnt;
    // console.log(answer);

    // (2) (1) 리팩토링
    // while(x !=1 && cnt != 500){
    //     x%2 == 0 ? x = x/2 : x = x*3 +1
    //     answer ++;
    // }
    // console.log(x ==1 ? answer : -1);

    // (3) recursion
    // function recursionSol(x, count = 0){
    //     return x == 1 ? (count >= 500 ? -1 : count) : recursionSol(x % 2 == 0 ? x / 2 : x * 3 + 1, count += 1);
    // }
    // var re = recursionSol(6);
    // console.log(re);

}

// Q8. GCD & LCM
function q8() {
    //두 수를 입력받아 두 수의 최대공약수와 최소공배수륿 반환하는 함수
    // answer[0] = GCD, answer[1] = LCM
    // 유클리드 호재법을 이용하자.
    var answer = []
    var n = 7, m = 16;
    var a = Math.max(n, m);
    var b = Math.min(n, m);
    // const gcd = (a, b) => {
    //     if(b===0) {return a;}
    //     return gcd(b, a % b);
    // };
    // gcd(48, 10) > gcd(10, 8) > gcd(8, 2) > gcd(2, 0) > 2

    // (1) 간단하게 표현
    const gcd = (a, b) => b === 0 ? a : gcd(b, a % b);
    const lcm = a * b / gcd(a, b);
    answer.push(gcd(a, b), lcm);

    // (1-2) 함수화
    // function gcd(a,b){
    //     return b ? gcd(b, a%b) : a;
    // }
    // function lcm(a,b){
    //     return a * b / gcd(a,b);
    // }
    // function gcdlcm(a,b){
    //     return [gcd(a,b), lcm(a,b)];
    // }
    // gcdlcm(a,b);
    console.log(answer);
}

// Q9. 짝수(Even)와 홀수(Odd)
function q9() {
    var answer = '';
    var num = 3;
    num % 2 ? answer = 'Even' : answer = 'Odd';
    console.log(answer);
}

// Q10. 배열 중 제일 작은 수 제거하기(정렬 X)
function q10() {
    var arr = [3, 4, 1, 2];

    // (1)
    // arr.splice(arr.indexOf(Math.min(...arr)),1);
    // if(arr.length<1)return[-1];
    // return arr;

    // (2)
    // function solution(arr) {
    //     if (arr.length <= 1) return [-1];
    //     let min;
    //     arr.reduce((acc, cur) => min = cur > acc ? acc : cur);
    //     return arr.filter(e => e !== min);
    //   }

    //   console.log(solution([4,3,2,1]));
    //   // Expected output: [4, 3, 2]
    //   console.log(solution([10]));
    //   // Expected output: [-1]


}

// Q11. 정수 제곱근 판별
function q11() {
    // 임의의 양의 정수 n에 대해, 양의 정수 x의 제곱인지 아닌지 판단
    // n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고
    // 아니라면 -1을 리턴하는 함수를 완성해라.
    var n = 121;
    var answer = 0;
    var x = 1;
    // (1) sqrt, pow 메서드 사용하기

    // 정수인지 아닌지 판별하는 2가지 방법
    // console.log(Number.isInteger(Math.sqrt(n)));
    // console.log((Math.sqrt(n)%1 === 0));
    while (x ** 2 < n) {
        x ** 2 === n ? true : x++;
    }
    console.log(`x : ${x}`);

    (x ** 2 % 1 === 0) ? answer = Math.pow(Math.sqrt(n) + 1, 2) : answer = -1;
    // console.log((Math.sqrt(n)+1)**2);    


    return answer;
}

// Q12. 정수 내림차순으로 배치하기
function q12() {
    // 정수 n을 입력받아 큰순부터 작은순으로 정렬 후 새로운 정수 리턴
    var n = 118372;
    var answer = String(n).split('');
    var new_number = '';
    var ab = n + '';
    console.log(`ab : ${ab}`);
    var tmp = 0;
    var i = 0;
    while (i < answer.length) {
        for (var j = 0; j < answer.length - 1; j++) {
            if (answer[j] < answer[j + 1]) {
                tmp = answer[j + 1];
                answer[j + 1] = answer[j];
                answer[j] = tmp;
            }
        }
        i++;
        // console.log(answer);
    }
    for (var k = 0; k < answer.length; k++) {
        new_number += answer[k];
    }
    new_number = parseInt(new_number);
    console.log(new_number);
}

// Q13. 자연수 뒤집어 배열로 만들기
function q13() {
    var n = 12345;

    // (1)
    // var answer = String(n).split('');
    // var i = 0;
    // var tmp = 0;
    // var k = answer.length-1;
    // while(i < answer.length){
    //     for(var j=0; j< k; j++){
    //         tmp = answer[j+1];
    //         answer[j+1] = answer[j];
    //         answer[j] = tmp;


    //     }
    //     i++;
    //     k--;

    // }

    // for(var l =0; l< answer.length; l++){
    //     answer[l] = parseInt(answer[l]);
    // }

    // console.log(`result answer : ${answer}`);

    // (2) Gooooooooooooooood!
    var arr = [];

    do {
        arr.push(n % 10);
        n = Math.floor(n / 10);
    } while (n > 0);

    console.log(arr);

    // (3)
    // console.log(n.toString().split('').reverse().map(o => o = parseInt(o)));
    // console.log(String(n).split('').reverse().map(o => parseInt(o)));
}

// Q14. 자릿수 더하기
function q14() {
    var n = 123456789;
    var sum = 0;
    var nLength = (String(n).split('')).length;
    var arr = String(n).split('');
    // for(var i = 0; i < nLength; i++){
    //     arr[i] = parseInt(arr[i]);
    //     sum += arr[i];
    // }
    // console.log(sum);

    var sum1 = (acc, cur) => parseInt(acc) + parseInt(cur);
    //const map1 = arr.map(x => parseInt(x));
    // console.log(map1);
    var r = arr.reduce(sum1);
    console.log(`map을 쓴 경우 : ${arr.reduce(sum1)}`);


    //map과 reduce 차이점 확실히 알기 !
}

// Q15. 이상한 문자 만들기
function q15() {
    var s = "try hello world";
    var arr = String(s).split(" ");
    var answer = '';
    console.log(arr);
    for (var j = 0; j < arr.length; j++) {
        for (var a = 0; a < arr[j].length; a++) {
            if (a % 2 !== 0) {
                answer += arr[j][a].toLowerCase();
            }
            else {
                answer += arr[j][a].toUpperCase();
            }
        }
        if (j < arr.length - 1) {
            answer += " ";
        }
    }
    return answer;
}

// Q16. 약수의 합
function q16(n) {

    // (1)
    var answer = 0;
    for (var i = 1; i < n + 1; i++) {
        if (!(n % i)) {
            answer += i;
        }
    }
    return answer;

    // (2) 더 나은 시간복잡도
    // var answer = 0;
    // let i;
    // for (i = 1; i <= Math.sqrt(n); i++){
    //     if (!(n%i)) {
    //         answer += (i+n/i);
    //     }
    // }
    // i--;
    // return (i === n/i) ? answer-i : answer;
}

// Q17. 문자열을 정수로 바꾸기
function q17(s) {
    //(1)
    return parseInt(s);
    //(2)
    return Number(s);
    //(3)
    return +s;
    //(4)
    return s / 1;
    //(5)
    return Math.floor(s);
}

// Q18. 소수 찾기
function q18() {
    var answer = 0;
    var n = 10;
    // var arr = [];
    for (var i = 2; i <= n; i++) {
        for (var j = 2; j <= i; j++) {
            // if(arr[j]%2 ===0 && arr[j] !== 2){ arr[j] = 0 }
            // if(arr[j]%3 ===0 && arr[j] !== 3){ arr[j] = 0 }
            // if(arr[j]%5 ===0 && arr[j] !== 5){ arr[j] = 0 }
            // if(arr[j]%7 ===0 && arr[j] !== 7){ arr[j] = 0 }
            if (i % j == 0) {
                if (i / j !== 1) {
                    break;
                }
                answer++;
            }
        }
    }
    // answer = arr.filter(n => n !== 0).length;
    // console.log(arr.filter(n => n !== 0));
    console.log(answer);
}



// 함수 로드
function load() {
    //q1();
    // tree();
    // mapMethod()
    // var outputQ2 = q2(2, 5);
    // console.log(outputQ2);

    // const a = q2(2,5);
    // console.log(a);

    // const b = q3();
    // console.log(b);

    // q4();

    // var r1 = q5();
    // console.log(r1);

    // q6();

    // q7();

    // q8();

    // q9();

    // q10();

    // var r2 = q11();
    // console.log(r2);

    // q12();

    // q13();

    // q14();

    // q15();

    // var r3 = q16(15);
    // console.log(r3);

    // var r4 = q17("12345");
    // console.log(typeof(r4));

    q18();
}

// 초기화
function init() {
    load();
}

init();