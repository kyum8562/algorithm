const obj = {'S' : single,
             'D' : double,
             'T' : triple,
             '*' : starSang,
             '#' : archaSang};

function isChar(char){
    return obj[char];
}
function single(stack){
    if(stack.length >= 1){
        var score = Math.pow(stack.pop(), 1);
        stack.push(score);    
    }
    return stack;
}
function double(stack){
    if(stack.length >= 1){
        var score = Math.pow(stack.pop(), 2);
        stack.push(score);
    }
    return stack;
}
function triple(stack){
    if(stack.length >= 1){
        var score = Math.pow(stack.pop(), 3);
        stack.push(score);
    }
    return stack;
}
function starSang(stack){
    if(stack.length >= 1){
        var currScore = stack.pop()*2;
        if(stack.length >=1){
            var prevScore = stack.pop()*2;
            stack.push(prevScore);
        }
        stack.push(currScore);
    }
    return stack;
}
function archaSang(stack){
    if(stack.length >= 1){
        var score = stack.pop()*(-1);
        stack.push(score);
    }
    return stack;
}


function dart(r) {
    // 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임
    // 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨시 1/2/3제곱의 점수로 계산
    // 옵션으로 스타상(*), 아차상(#)이 존재하며
    // 스타상(*) 당첨시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다.
    // 아차상($) 당첨시 해당점수는 마이너스가 된다.
    // 스타상은 첫 번째 기회에서도 나올 수 있다. 이 경우 스타상의 점수만 2배가 된다.
    // 스타상의 효과는 다른 스타상의 효과와 중첩될 수 있다 이 경우 중첩된 스타상의 점수는 4배이다.
    // 스타상의 효과는 아차상의 효과와 중첩될 수 있다. 이경우 중첩된 아차상의 점수는 -2배가 된다.
    // Single, Double, Triple는 점수마다 하나씩 존재한다.
    // 스타상, 아차상은 점수마다 중중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
    // 0~10의 정수와 S,D,T,*,#로 구성된 문자열이 입력될시 총점수를 반환하는 함수를 작성해라
    //"점수|보너스|[옵션]"으로 이루어진 문자열 3세트 ex) 1S2D*3T
        // 점수는 0~10사이의 정수이다
        // 보너스는 S,D,T 중 하나이다
        // 옵션은 * 과 # 중 하나이며 없을 수도 있다.
    // 3번의 기회에서 얻은 점수 합계에 해당하는 정수값을 출력한다.
    var answer = 0;
    var stack = [];
    console.log(`r : ${r}`);
    for(var i = 0 ; i < r.length ; i ++){
        var number = parseInt(r.slice(i));
        if(Number.isInteger(number)){
            stack.push(number);
            i += number.toString().length -1;
        }
        else{
            var a = r.charAt(i);
            const obj = isChar(a.toUpperCase());
            obj(stack);
        }
    }
    console.log(`stack : ${stack}`);

    answer = stack.reduce((prev,curr) => prev + curr);
    return answer;
}

function load() {
    var result = dart("10D1S*1S");
    console.log(`result : ${result}`);
}
function init() {
    load();
}
init();