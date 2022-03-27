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
console.log(solution(2, 10, [7, 4]));