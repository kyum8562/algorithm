//자릿수 합이 최대인 자연수를 출력해라
//값이 동일할 경우, 원래의값이 큰 것을 출력
function solution(arr){
    let currMaxVal = 0;
    let currMaxSum = 0;
    for(let x of arr){
        // 내장함수 사용 방법
        let sum = x.toString().split('').reduce((a,b) => +a + +b);
        sum;
        // console.log(sum);

        // 일반적인 방법
        //    let sum = 0, tmp = x;
        //    while(tmp){
        //        sum += tmp%10;
        //        tmp = Math.floor(tmp/10);
        //    }
       if(sum > currMaxSum){
           currMaxVal = x;
           currMaxSum = sum;
       } 
       else if(currMaxSum === sum){ currMaxVal > x ? currMaxVal : currMaxVal = x; }
    }

    return currMaxVal;
}

console.log(solution([128, 460, 603, 40, 521, 137, 123]));


/*
n = 128 / n.length = 3
나누는수 = /parseInt("1" + "00") -> n.length -1만큼 0붙임
answer += n/나누는수 -> 첫번째 자리 들어감
tmp = n%나누는수 -> 첫번째자리 빼고 들어감

if(tmp <10) return answer += tmp 
else n = tmp

*/