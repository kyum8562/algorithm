// statement(문장)
// 문장은 명령을 수행(ex if, for)
// 자바스크립트 프로그램이란 문장의 모음
// 표현문 i++; ++i; delete a.a; ... etc

// 복합문 : 문장 + 문장 + ... (이는 중괄호로 묶어줌)

// false를 띄는 값 : 0, -0, false, NaN, undefined
// 이외의 값은 모두 true

// 0 과 -0은 다르다
// 1/0을 나누면 +infinity 1/-0을 나누면 -infinity

//js는 들여쓰기를 통해서 프로그램에 영향을 미치지 않는다. 
// 하지만 코드의 가독성을 위해서 적절한 중괄호를 함으로써 가독성을 높인다.
// 프로그램 작성을 모두하고, 다른 사람들이 코드를 볼 때 가독성을 떨어뜨리기 위해
// uglify(enter, 들여쓰기, 중괄호 등 제거)를 함으로써 코드를 쉽게 보지 못하게 한다.
if(true)
    if(false)
        console.log(1);
    else
    console.log(2);


 