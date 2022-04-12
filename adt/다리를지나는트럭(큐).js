// 다리를 지나는 트럭(큐)
function solution(bridge_length, weight, truck_weights) {
    // 다리를 모두 건너는데 걸리는 시간
    let sec = 0;

    // 현재 다리의 무게
    let remainWeight = 0;

    // 다리
    let bridge = [];
    for(let i = 0 ; i < bridge_length ; i ++){
        bridge.push(0);
    }

    // 현재 지나가는 트럭
    let currTruck = truck_weights.shift();

    bridge.unshift(currTruck);
    bridge.pop();
    
    remainWeight += currTruck;
    
    sec++;
    console.log(bridge, sec);

    while(remainWeight){
        remainWeight -= bridge.pop();

        currTruck = truck_weights.shift();

        if(currTruck+remainWeight <= weight){
            bridge.unshift(currTruck);
            remainWeight+= currTruck;
        }
        else{
            bridge.unshift(0);
            truck_weights.unshift(currTruck);
        }
        
        sec++;
        console.log('sec : ', sec);
        console.log('birdge : ', bridge);
        console.log('currTruck : ', currTruck);
        console.log('remainWeight : ', remainWeight);
        console.log();
    }



    return sec;
}
console.log(solution(2, 10, [7, 4, 5, 6]));


/*
2번째 풀이
function solution(다리길이, 다리최대무게, 남은트럭){
    let sec = 1;
    let 현재무게 = 다리최대무게;
    let 다리 = [];
    for(let i = 0 ; i < 다리길이 ; i++){
        다리.push(0);
    }
    // 남은 트럭이 없을 때 까지 반복
    while(1 === 1){

        현재무게 += 다리.pop();
        다리.unshift(0);

        // 현재 무게가 충분하다면
        if(현재무게 >= 남은트럭[0]){
            // 현재무게에서 들어올 트럭의 무게를 빼고
            현재무게 -= 남은트럭[0];
            // 다리를 팝해준뒤 현재무게를 채워준다
            현재무게 += 다리.pop();
            // 들어올 트럭을 다리의 앞부분에 넣어준다
            다리.unshift(남은트럭.shift());
        }

        if(다리.reduce((x,y) => x+y) === 0){
            break;
        }

        //초를 늘려준다
        sec++;

    }

    return sec;
}

console.log(solution(2, 10, [7, 4, 5, 6]));


*/