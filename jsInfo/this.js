// this란 무엇일까?
// 전역 : window
// 함수 내부 : 함수를 실행하면 마지막 .(점) 앞을 this로 함수에 전달한다.
//             없으면 전역을 전달한다.

// this를 바꾸는 방법
// call
// apply
// bind:this가 바인딩 된 함수를 반환한다.

// 자바에서 this는 자기 자신인 객체를 가리킨다.
// 하지만 js에서는 자기 자신을 가리키지 읺는다.(잘못된 예)
// function a(){
//     this();
// }

// 스코프를 가리키지 않는다.(잘못된 예)
// function a() {
//     var a = 0;
//     (function () { console.log(this.a)})();
// }

//1의 this는 window, 2의 this는 obj, 3의 this는 window를 가리킨다.
// .(점)의 앞부분에 있는것이 this이고 앞부분에 아무것도 없다면 window를 가리킨다.
// 2번에서 보았을 때 this는 obj에 바인딩 되었다 라고 표현할 수 있다.
// var obj = {
//     a : console.log("1 : " + this),
//     fn : function(){
//         console.log("2 : " + this);
//         function fn(){
//             console.log("3 : " + this);
//         }
//         fn();
//     }
// }
// obj.fn();

// var obj2 = {
//     fn: function() {
//         console.log(this);
//     }
// }
// setTimeout(obj2.fn.bind(obj2), 100);
