function reptMethod(){
    // String.repeat(n) Method : String 반복
    const str = "A";

    console.log(str.repeat(3)); // 반복횟수는 양의 정수

    // Array.join() Method : 배열의 모든 요소를 연결해 하나의 문자열로 만든다
    const elements = ['A', 'B', 'C'];

    console.log(elements.join());
    console.log(elements.join(''));
    console.log(elements.join('-'));
}
function q1(){
    // Q1. 직사각형 별찍기
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

function q2(){
    // Q2. x만큼 간격이 있는 n개의 숫자

}








function load(){
    //q1();
    tree();
}

function init(){
    load();
    }
    
    init();