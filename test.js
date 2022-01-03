// String에서 배열 만들기
const d = Array.from('foo');
console.log(d);

// Set에서 배열 만들기
const s = new Set(['foo', 'abc']);
console.log(Array.from((s), x => x+x));

const b = new Set([123, 456]);

//Map에서 배열 만들기
const c = new Map([[123,1], [456,2]]);
console.log(Array.from(c.values()));
console.log(Array.from(c.keys()));


// 배열 형태를 가진 객체에서 배열 만들기
function f() {
    return Array.from(arguments);
}
console.log(f(1,2,3));


// Array.from과 화살표 함수 사용하기
const e = Array.from({length:5}, (_,i) => (i+1) *2);
console.log(e);


// 시퀀스 생성기(range)
const range = (start, stop, step) => Array.from({length: (stop-start)/step +1}, (_,i) => start + (step*i));
console.log(range(1,4,1));


// map 메소드
function mapMethod(){
    const arr1 = [1, 4, 9 ,15];
    const map1 = arr1.map(x => x * 2);
    return map1;
}

// repeat 반복 메소드
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








