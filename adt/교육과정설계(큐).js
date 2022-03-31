/*
교육과정 설계

*/
function solution(goal, plan){
    // let queue = Array.from({length:str1.length}, (v,i) => str1[i]);

    // for(let i = 0 ; i < queue.length ; i ){
    //     for(let j = 0 ; j < plan.length ; j ++){
    //         if(queue[i] === plan[j]){
    //             queue.shift();
    //             break;
    //         }
    //         else if(queue.includes(plan[j])) return "NO";
    //     }

    // }

    // if(queue.length === 0) return "YES";
    // else return "NO";

    let answer = "YES"
    let queue =goal.split('');

    for(let x of plan){
        if(queue.includes(x)){
            if(x!== queue.shift()) return "NO";
        }
    }
    console.log(queue);
    if(queue.length > 0) return "NO";
    return answer;
}

console.log(solution('CBA', 'CBDBGE'));
