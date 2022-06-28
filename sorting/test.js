// function solution1(nums, operations) {
//     let res = [];
//     for(let i = 0 ; i < nums.length ; i ++){
//         if(operations[i] === "i") res.push((parseInt(nums[i])+1)+"");
//         else if(operations[i] === "m") res.push((parseInt(nums[i])*2)+"");
//         else res.push((parseInt(nums[i])-1)+"");
//     }
//     return res;

// }

// console.log(solution1(["5", "2", "4", "3"], ["i", "i", "d", "m"]));

// function solution2(s, t) {
//     let res = true;
//     let hash = new Map();
//     for(let i = 0 ; i < s.length; i ++){
//         if(!hash.has(s[i])) hash.set(s[i], 1);
//         else hash.set(s[i], hash.get(s[i])+1)
//     }
//     for(let v of t){
//         if(!hash.has(v)) return res = false;
//     }
//     return res;
// }

// console.log(solution2("imfinethankyou", "atfhinemnoyuki"));

// function solution3(N, M, amount, value, stomach) {
//     let amountSum = stomach.reduce((sum, curr) => {return sum + curr});
//     let items = [];
//     let result = 0;
//     let i = 0;
//     while(amountSum >0 && i <= amount.length){
//         if(amountSum - amount[i] > 0){
//             result += amount[i] * value[i];
//             amountSum -= amount[i];
//         }
//         else{
//             result += amountSum * value[i];
//             amountSum = 0;
//         }
//         i++;
//     }
//     return result;
// }

// console.log(solution3(4,
//                       5,
//                       [7, 10, 4, 5],
//                       [5, 4, 3, 1],
//                       [4, 6, 2, 5, 3])
//             );

// function solution4(numbers, target) {
//     let res = -1;
//     let nums = numbers.sort((a,b) => b-a);
//     let tgt = target;
//     let cnt = 0;
//     for(let i = 0 ; i < nums.length; i++){
//         if(tgt%nums[i] === 0 && nums[i] !== 1){
//             tgt /= nums[i];
//             cnt++;
//         }
//         // 배열 내 덧셈을 통해 합한 값이 나눠지는지 판단
//     }
    
//     return (tgt===target) ? -1 : cnt;
// }

// console.log(solution4([1, 4, 2], 12));


/*

제로는 배열 `numbers`에 주어진 여러 숫자를 이용하여, 특정한 숫자 `target`을 만드려고 한다.

배열에 있는 숫자는 중복해서 여러번 사용할 수 있으며, 이 숫자들을 곱하거나 더해서 새로운 숫자를 만들 수 있다.

숫자를 조합하는 수식에는 괄호가 사용 가능하여, 예를 들어 아래와 같은 계산이 가능하다.

`4*(2+5)+3`

이 때, `target`을 표현하는 데에 필요한 최소의 숫자의 개수를 구하시오.

(단, `100`개의 숫자를 이용해도 표현할 수 없다면 `-1`을 출력하시오)

## 입력설명

- `0 <= numbers[i] <= 100`
- `1 <= numbers.length <= 100`
- `0 <= target <= 1000000`

## 출력설명

`target` 값을 표현하는 데에 필요한 최소의 숫자의 개수를 정수로 출력

## 매개변수 형식

`numbers = [1, 4, 2]`
`target = 12`

## 반환값 형식

`3`

## 예시 입출력 설명

`4*(2+1) = 12`로, 총 3개의 숫자를 이용하여 표현할 수 있다.
*/


