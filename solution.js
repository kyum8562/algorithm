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

    // for 반복문을 이용
    // for(var k = 0; k<b; k++){
    //     result = "";
    //     for(var l = 0 ; l<a; l++){
    //         result += '*';
    //     }
    //     console.log(result);
    // }
}

function init(){
q1();
}

init();