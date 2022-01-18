// expression(표현식)
// 답을 만들 수 있다면 모두 표현식(리터럴 표현식 - 숫자, 문자, 객체, 배열, 함수)

// --i(전치) : i = i -1 / i--(후치) t = i , i = i -1 (t를 반환)
// i=5d에서 [4로 바뀌고 a++] 의 연산을 i가 -1가 되면 연산 종료  
var a = 0;
for(var i = 5 ; i --;){a++};
console.log(a);

// i=5에서 [4로 바뀌고 b++] 의 연산을 i가 0이되면 연산 종료
var b = 0;
for(var i = 5 ; i --, i;){b++};
console.log(b);

//&&

// c() && d() : c()의 결과값이 false라면 d()를 실행하지 않는다. 
// function c(){
//     console.log(1); return false;
// }
// function d(){
//     console.log(2); return true;
// }
// c() && d();

// // fn안에있는 인자를 먼저 실행하기 때문에 c와 d가 모두 실행된다.
// function fn(c,d){
//     return c && d;
// }
// fn(c(),d());

//||

// c() || d() : c값이 true이라면 d를 실행하지 않는다.
// defalut로 사용이 가능한 실제 사용 함수
// 예를들어 undefined라면 {}값을 호출하는 조건을 매번 준다면 코드가 복잡해진다.
// 따라서 아래와 같이 메소드를 만들고 함수만 호출함으로써 코드의 가독성이 높아지며 간결해진다.
function fn(options){
    options = options || {}
    console.log(options);
}
fn();
