// valueOf() : 해당 메소드는 특정 객체의 원시 값을 반환한다.
// toString() : 해당 메소드는 문자열을 반환한다.

// ===(일치 비교)에서의 기본형(string, number, boolean, null, undefined, symbol)은 형과 값이 일치해야 하고
//                      참조형(array, object)에서는 참조위치(래퍼런스)가 일치해야 한다.

// == (동치 비교) 에서 문자열이 나오게 된다면 (자동으로) 숫자로 변환시킨 뒤에 연산 결과를 반환한다.
// 동치 비교는 형을 신경쓰지 않고 값만 가지고 비교를 한다.
// 그렇기 때문에 문자와 숫자비교에서는 문자를 숫자로 변환하고 일치 비교하는 것과 동일하다.
// 참조형과 기본형 비교에서는 참조형을 기본형으로 바꾸어주고 비교를 해준다.
// ㄴ 참조형.valueOf().toString()을 하고 비교를 실시하는 것과 동일하다.
// ===(일치 비교)가 참이면 ==(동치 비교)도 참이다.
// 


console.log(`Q1. 2 == '2' : ${2 == '2'}`);                                   // 숫자와 문자 비교
console.log(`Q2. 2 == '2'.valueOf() : ${2 == '2'.valueOf()}`);               // 숫자와 문자.valueOf() 비교
console.log(`Q3. 2 == Number(2).valueOf() : ${2 == Number(2).valueOf()}`);   // 숫자와 Number(2).valueOf() 비교
console.log(`Q4. 2 == Number(2).toString() : ${2 == Number(2).toString()}`); // 숫자와 Number(2).toString() 비교
console.log(`Q5. 2 == 2 .toString() : ${2 == 2 .toString()}`);               // 2 .toString()는 점(.) 부분 앞에 공백이 있기에 이후에 숫자(소수 때문)이 아닌 문자가 와도 된다.
// console.log(`Q6. 2 == 2.valueOf() : ${2 == 2.valueOf()}`);                // 2. 다음에는 숫자(소수이기 때문에)가 나오지 않아서 SyntaxError 발생
console.log(`Q7. 2 == 2.23.valueOf() : ${2 == 2.23.valueOf()}`);             // 2.23 다음에는 더 이상 숫자가 올 수 없기에 정상 이다.

console.log(`Q8. null == undefined : ${null == undefined}`);                 // null == undefined은 동치 비교에서는 true
console.log(`Q9. null === undefined : ${null === undefined}`);               // null === undefined은 일치 비교에서는 false
console.log(`Q10. [2,3] == '2,3' : ${[2,3] == '2,3'}`);                      // 숫자와 문자 비교
console.log(`Q11. true == '1' : ${true == '1'}`);                            // true(boolean)과 '1' 문자 비교

console.log([1,2] < [3,4]);
// valueOf를 하면 양쪽의 객체는 자기자신값인 객체가 나오게된다.
// toString을 이용하면 '1,2'와 '3,4'가 나오게 되는데
// 앞의 수 1과 3을 비교하고 2와 4를 비교해서 참이므로 true 반환


