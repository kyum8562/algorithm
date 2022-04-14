// 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 출력해라

// 소수판별 함수
function isPrime(n){
    if(n === 1) return false;
    else{
        for(let i = 2 ; i <= parseInt(Math.sqrt(n)) ; i ++){
            if(n%i === 0) return false;
        }
    }
    return true;
}

function solution(arr){
    let answer = [];
    for(let x of arr){
        let tmp = 0;

        // case 1
        // while(x){
        //     let t = x%10; 
        //     tmp = tmp*10+t;
        //     x = parseInt(x/10);
        // }

        // case 2
        // x = x.toString().split('');
        // for(let i = x.length-1 ; i >=0 ; i--){
        //     tmp += x[i];
        // }

        // case 3
        tmp = x.toString().split('').reverse().join('');
        // console.log(tmp);

        if(isPrime(+tmp)) answer.push(+tmp);
    }
   
    return answer;
}


console.log(solution([32, 55, 62, 20, 250, 370, 200, 30, 100]));
// 개닷값 : 23 2 73 2 3