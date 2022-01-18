// prototype에 대해서 @@@@@@@@@@@@@@@@@@@@@@@@@@@

// prototype은 다른 객체에 기반이 되는 객체이다.
// 
function Person(){
    this.name = 'SUN'
}

Person.prototype.getName = function(){return this.name};
Person.prototype.lang = function(){return 'JS'};
var p = new Person();
console.log(p.getName() + p.lang());

// 생성자 만듦
function Programmer(){
    this.name = "kim";
}
// 생성자의 프로토타입에 new Fn()을 해서 실행
// 프로토 타입을 변경할 수 있다.

// 또한 프로토타입의 new Fn()을 한다면 
// 프로토 타입을 변경할 수 있다.
// 위와 아래의 경우는 프로토타입 체인이 변경된다.
Programmer.prototype = new Person();
var sun = new Programmer();
// prototype chain을 통해서 sun의 getName을 사용
delete sun.name;
sun.name = 'sun2';
console.log(sun.getName());



