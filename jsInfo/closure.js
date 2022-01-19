//   실행문맥 생성
//   실행문맥은 크게 3가지로 이루어져 있다.
//   활성화 객체 : 실행에 필요한 여러 arguments 객체, 변수들을 담을 객체
//   유효범위 정보 : 현재 실행 문맥의 유효범위
//   this 객체 : 현재 실행 문맥을 포함하는 객체

//   실행문맥의 생성 순서
//   1. 활성화 객체 생성
//   2. arguments 객체 생성
//   3. 유효범위 정보 생성
//   4. 변수 생성
//   5. this 객체 바인딩
//   6. 실행
//  */
//   /* 유효범위 체인
//   함수가 중첩함수일 때, 상위함수의 유효범위까지 흡수하는 것을 말한다.
//   즉, 하위함수가 실행되는 동안 참조하는 상위변수 또는 함수의 메모리를 참조하는 것.
//   앞서 실행 문맥 생성에 대해 설명했듯이 유효범위를 생성하고 해당 함수를 호출한
//   부모함수가 가진 활성화 객체가 리스트에 추가된다.
//   쉽게 말해서, 전역 변수 객체, 상하위 객체 간에 부모/자식 관계가 형성된다고 생각하면 쉽다.
//  */
//  /*  closure
//   클로저는 js의 유효범위 체인을 이용하며 이미 생명주기가 끝난 외부함수의 변수를 참조하는 방법이다.
//   외부함수가 종료되더라도 내부함수가 실행되는 상태면 내부함수에서 참조하는 
//   외부함수는 닫히지 못하고 내부함수에 의해서 닫히게 되어 클로저라고 불린다.
//   따라서, 클로저란 외부에서 내부 변수에에 접근할 수 있도록 하는 함수이다.
//   내부 변수는 하나의 클로저에만 종속될 필요는 없으며 외부함수가 실행될 때마다
//   새로운 유효범위 체인과 내부 변수를 생성한다.
//   또한, 클로저가 참조하는 내부변수는 실제 내부변수의 복사본이 아닌 그 내부 변수를
//   직접 참조한다.
//  */
//   /* closure의 사용이유
//   전역변수의 오,남용이 없는 깔끔한 스크립트를 작성할 수 있다.
//   같은 변수를 사용하고자 할 때, 전역변수가 아닌 클로저를 통해 같은 내부변수를 참조
//   하게 되면 전역변수의 오남용을 줄일 수 있다.
//   또한 클로저는 js에 적합한 방식의 스크립트를 구성하고 다양한 js의 디자인패턴을 적용할 수 있다.
//   대표적인 예시로 모듈 패턴이 이에 해당한다.
//   함수 내부의 함수를 이용해 내부변수 또는 함수에 접근함으로써 js에 없는 class의 역할을
//   비공개 속성/함수, 공개 속성/함수에 접근함으로써 class를 구현하는 근거

//   closure의 주의점
//   for문 클로저는 상위함수의 변수를 참조할 때 자신의 생성될 때가 아닌 내부변수의 최종값을 참조한다.
//  */
// /* [ 클로저 사용예제(1) - 서로 다른 클로저(innerFunc1,innerFunc2)가 같은 내부변수 참조] */
function outerFunc(){
  var a = 0;
  return { 
    innerFunc1 : function(){
      a += 1;
      console.log("a=" +a);
    },
    innerFunc2 : function(){
      a += 2;
      console.log("a=" +a);
    }
  };
}
var out = outerFunc();
out.innerFunc1();
out.innerFunc2();
out.innerFunc2();
out.innerFunc1();
// >> 실행결과 : a=1, a=3, a=5, a=6

// // [ 클로저 사용예제(2) - 같은 함수 but 다른 객체(다른 내부변수 사용)]
// function outerFunc(){
//   var a = 0;
//   return { 
//     innerFunc1 : function(){
//       a += 1;
//       console.log("a=" +a);
//     },
//     innerFunc2 : function(){
//       a += 2;
//       console.log("a=" +a);
//     }
//   };
// } // 여기까지 사용예제(1)과 동일
// var out = outerFunc();
// var out2 = outerFunc();
// out.innerFunc1();
// out.innerFunc2();
// out2.innerFunc1();
// out2.innerFunc2();

// function sum(num) {
//     let total = 0;
//     for (let i = 0; i<num; i++){
//           total += i;
//           printTotal(total);
//       }
//       return total;
//   }
  
//   function printTotal(num) {
//         console.log('예상하지 못한');
//         console.log(`total: ${num}`);    
//     }
    
//     const result = sum(10);
//     console.log(result);

// 스코프(유효 범위)
// ㄴ 어휘적 유효범위(함수 정의 환경)
// ㄴ 최상위는 전역객체(전역객체만 스코프를 가리키지않고 나머지는 스코프를 가리킨다)
// ㄴ 함수 선언, catch
// ㄴ 중첩(블록) 스코프 가능 (ECMA6 이상 const, let)

//ex1
// var x = 1;
// function innerF(){
//     return 1 + x;
// }
// function outterF(){ 
//     var x = 2;
//     return innerF();
// }
// console.log(outterF());

// //ex2
// function a(){
//     var i = 0;
//     function b(){
//         var i = 1;
//         function c(){
//             console.log(i);
//         }
//         c();
//     }
//     b();
// }
// a();

// //ex3
function f1(x) {return {fn : function() {return x;}}}
var a = f1(0);
a.fn();

function f2(x) {return{};}
var a = f2(0);
a.fn = function () {return x};
a.fn();

// //ex4
// function fn(x) {
//     return function inner() {return x};
// };
// var f1 = fn(1);
// var f2 = fn(2);

// console.log(f1());
// console.log(f2());

//ex5
// function closure(start){
//     return function count(){
//         return {
//             inc: function() {start++;},
//             get: function() {return start;}

//         }
//     }
// }
// var f1 = closure(0);
// var f2 = f1;
// var f3 = closure(0);

// var fc1 = f1();
// var fc2 = f2();
// var fc3 = f3();
// var fc4 = fc1;
// fc1.inc();
// fc2.inc();
// fc3.inc();
// fc4.inc();
// var a = fc1.get();
// var b = fc2.get();
// var c = fc3.get();
// var d = fc4.get();


