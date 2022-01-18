// Hoisting은 어떻게 동작될까? @@@@@@@@@@@@@@@@

// 인터프리터 시점에서 보았을 때 모두 같은 스코프이니 var a 선언이 먼저 되고
// a에 2가 들어가게 된다. 이후 콘솔로그(a)를 통해서 2라는 값이 출력된다.
//ex0
  // a = 2;
  // var a;
  // console.log(a);
  
// *같은 스코프 내에서는 인터프리터 시점에서는 변수 선언이 먼저가 된다.(대입은 순서에 맞게)
//ex1 순서 : 전역에서변수테이블에 a='g'가 선언되고 fn을 실행하면 하위 변수 테이블이 만들어진다.
// 여기서 인터프리터 시점에서 보았을 때 var a(선언)이 먼저 되고 a의 값이 없는 상태에서
// 콘솔로그(a)가 찍히면 undefined가 나온다. 이후 a의 값에 l이 할당되고 두번째 콘솔로그(a)를 통해서 l이 출력된다.
//ex1
// var a = 'g'
// function fn(){
  //   console.log(a);
  //   var a = 'l';
  //   console.log(a);
  // }
  // fn();

//ex3
  // foo();
  // var foo = 2;
  // function foo(){
  //   console.log(1);
  // }
  // foo = function(){
  //   console.log(2);
  // }

// 함수는 지역변수를 해당 스코프에서 우선순위 컨텍스트이다.
// 또한 해당 스코프 안에서 사용하는 변수가 선언되어있지 않다면 부모 스코프(상위 스코프)에서
// (메모리) 변수를 찾게 된다.
// ex4
  // function abc(){
  //   var a = 'bbb';
  //   console.log("1 : " + a); //1
  //   function c(){
  //     console.log("2 : " + a); //2
  //     (function() {
  //         console.log("3 : " + a); //3
  //         a = 'ccc';
  //     })();
  //     var a;
  //     console.log("4 : " + a); //4
  //   }
  //   function d() {
  //     console.log("5 : " + a); //5
  //   }
  //   c();
  //   a = 'ddd';
  //   d();
  // };
  // abc();
  
// //ex5
//   function counter () {
//     for(var i=0; i<10; i++) {
//       console.log('i', i)
//     }
//   }
//   counter()
//   console.log('after loop i is', i) // ReferenceError: i is not defined

// //ex6
//   for(var j=0; j<10; j++) {
//     console.log('j', j)
//   }
//   console.log('after loop j is ', j) // after loop j is 10
  
//  /*  두 번째 for문의 경우 var가 hoisting 되었기에 정상출력이 되지만,
//   첫 번째 for문의 경우는 에러가 발생한다.
  
//   *scope 개념 이해
//   scope는 범위(유효범위)를 뜻함
//   js에서 scope는 변수와 매개변수(parameter)의 접근성과 생존기간을 뜻한다.
//   유효범위의 종류는 크게 두가지로 이루어진다
//   1. 전역 유효범위(Global scope)
//   2. 지역 유효범위(Local scope)
// 전역 유효범위는 스크립트 전체에 참조되는것을 의미하며
// 지역 유효범위는 정의된 함수 안에서만 참조되는것을 의미한다.


// js에서의 유효범위는 다른 프로그래밍 언어와 다른 개념을 갖는다.
// js 유효범위만의 특징을 크게 분류하여 나열하면 다음과 같다.
//   1. 함수 단위의 유효범위(함수단위의 depth에 해당하는 변수만 유효)
//   2. 변수의 중복 허용(변수명의 중복이 있어도 에러x, but 가장 가까운 변수 참조)
//   3. var 키워드의 생략(var 키워드 생략시 전역변수로 선언된다)
//   4. 렉시컬 특성
//   ㄴ 함수 실행 시 유효범위를 함수 실행 환경이 아닌 함수 정의 환경으로 참조하는 특성
//   ㄴ 호이스팅(Hoisting) : 끌어올리기, 나르기 의미를 가진다. */
// //ex7
//   function f1(){
//     var a = 10;
//     f2();
//   }
//   function f2(){
//     return a;
//   }
//   f1();
// //   >> 렉시컬 특성으로 인해 a를 호출하지 못하고 오류가 발생한다.

// //ex8
//   function f3(){
//     var value;
//     console.log("value=" +value);
//     value = 10;
//     console.log("value=" +value);
//   }
//   f3();
// /*   >> value = undefined
//      value = 10
//      다른 언어의 경우 첫 번째 호출에서 오류가 나야하지만, 
//      js에서는 호이스팅 특성으로 초기화 되지 않은 value가 지역상단으로 올라오게 되고
//      선언문이 있던 자리에서 초기화가 이루어 진다.
//  */

// //ex9
//   var value = 30;
//   function f4(){
//     console.log("value=" +value);
//     var value = 10;
//     console.log("value=" +value);
//   }
//   f4();
// /*   >> value= undefined
//      value = 10
//      호이스팅으로 인해 f4의 함수가 최상단으로 이동하기에 
//      value=30이 전역변수로 참조되지않고 지역변수 내에서만 호출이 되었다.
//      여러가지 함수정의 방법 중 함수 선언문 방식만 호이스팅이 가능하다.
//   */ 

// //ex10
  // f5()
  // function f5(){
  // var value = 10;
  // console.log("value=" +value);
  // }
// /*   >> value = 10



