// Q1. 직사각형 별찍기
function q1(){
    // 표준 입력으로 두 개의 정수 a, b가 주어지고
    // 별(*) 문자를 이용해 가로의 길이가 a, 세로의 길이가 b인 직사각형 형태 출력

    const a = 5, b = 3; // a, b는 임의의 수
    var result = "";

    // while 반복문을 이용

    var i = 0;
    var j = 0;
    while(j < b){
        while(i < a){
            result += `*`;
            i = i +1;
        }
    console.log(result);
    j = j +1;
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
function tree(){
    var resultSpace = [" "," "," ", " "," "," "," "," "," "," "];
    var result = "";
    var a = 0;
    var b = 10;

    for(var i=0; i< b; i++){
    result += '*';
    resultSpace.pop();
    console.log(resultSpace.join('') +result);
    result += '*';
    }
}

// Q2. x만큼 간격이 있는 n개의 숫자
function q2(x, n){
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
const nNumbers = (x, n) =>{
    return Array.from({length: n},(v,index) => (index+1)*x);
    };

// Q3. 행렬의 덧셈
function q3() {
    // 2개의 행렬 arr1과 arr2를 입력받아(행과 열의 크기가 같아야 함)
    // 행렬 덧셈의 결과를 반환하는 함수 만들기
    var answer = [[]];
    var arr1 = ([[5,2], [2,3]]);
    var arr2 = [[3,4], [5,6]];

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

    answer = A.map((a,i) => a.map((b,j) => b + B[i][j]));

    // 리턴
    return answer;
}

// Q4. 전화번호 뒷 4자리를 제외한 나머지 숫자 전부 *로 마스킹
function q4() {
    var phone_number = '01033921234';
    
    // (1)
    var front_number = phone_number.slice(0,-4);
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

}

// 함수 로드
function load(){
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
    q5();
}

// 초기화
function init(){
    load();
    }

init();