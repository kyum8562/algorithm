function validation(price, money, count){
    const pV = price <1 || price >2500 || price %1 !==0 ? "[price] " : '';
    const mV = money <1 || money >2500 || money %1 !==0 ? "[money] " : '';
    const cV = count <1 || count >2500 || count %1 !==0 ? "[count] " : '';
    const printVali = pV +  mV + cV + "유효성이 적절하지 않습니다.";
    if(pV.length !== 0 || mV.length !== 0 || cV.length !== 0) console.log(printVali);
}
function isHigh(money, calSum){ return money < calSum ? Math.abs(money-calSum): 0; }

function cal(price, count){
    var calSum = 0;
    for(var i = 1 ; i < count+1 ; i ++){
        calSum += price * i;
    }

    return calSum
}

function solution(price, money, count){
    // 새로 생긴 놀이기구는 인기가 많아 줄이 끊이질 않는다.
    // 이 놀이기구의 원래 이용료는 price원 인데, 놀이기구를 N 번째 이용한다면
    // 원래 이용료의 N 배를 받기로 했다. 즉, 처음 이용료가 100이 었다면 2번째에는 200,
    // 3번째에는 300으로 요금이 인상됩니다. 놀이기구를 count번 타게 되면 현재 자신이 가지고 있는
    // 금액에서 얼마나 모자라는지를 return 하도록 solution 함수를 완성하세요.
    // 단, 금액이 부족하지 않으면 0을 리턴하세요.

    // 제한사항
    // 놀이기구 이용료(price), 놀이기구의 이용 횟수(count) 1 <= price,count <= 2500 (price는 자연수)
    // 처음 가지고 있던 금액 1 <= money <= 1000000000 (money는 자연수)
    
    // 유효성 검사
    validation(price, money, count);

    var calSum = cal(price, count);
    var answer = isHigh(money, calSum);

    return answer;
    
    // (2)
    const tmp = price * count * (count +1) / 2 - money;
    return tmp > 0 ? tmp : 0;
}

function load(){
    var re = solution(3, 20, 4);
    console.log(re);
}
function init(){
    load();
}
init();