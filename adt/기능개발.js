// 기능개발
//

function solution(progresses, speeds) {
    const answer = [0];

    // for(var i = 0 ; i < progresses.length ; i ++){
    //     var tmp = ((100 - progresses[i])%speeds[i] == 0) ?
    //                 Math.floor((100 - progresses[i])/speeds[i]) :
    //                 Math.floor((100 - progresses[i])/speeds[i] +1);
    //     stack.push(tmp); 
    // }
    // console.log(`stack : ${stack}`);
    
    let days = progresses.map((progress, idx) => Math.ceil((100 - progresses[idx])/speeds[idx]));
    let maxDay = days[0];
    
    // for(var i = 0 ; i < stack.length ; i ++){
    //     var cnt = 0;
    //     for(var j = i+1 ; j < stack.length ; j ++){
    //         if(stack[i] >= stack[j] && stack[j] != null){
    //             cnt ++;
    //         }
    //         else{
    //             j = stack.length;
    //         }
    //     }
    //     (cnt == 0) ? answer.push(1) : answer.push(cnt+1);
    //     i += cnt;

    // }
    for(let i = 0, j = 0; i< days.length; i++){
        if(days[i] <= maxDay) {
            answer[j] += 1;
        } else {
            maxDay = days[i];
            answer[++j] = 1;
        }
    }
    return answer;
}


// console.log(solution([93, 30, 55],	[1, 30, 5]));
console.log(solution([95, 90, 99, 99, 80, 99],	[1, 1, 1, 1, 1, 1]));