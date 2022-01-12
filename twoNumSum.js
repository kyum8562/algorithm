function solution(numbers){
    // 두 개 뽑아서 더하기
    // 정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 
    //더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
    
    // number 배열을 내림차순으로 정렬
    var answer = numbers.sort((a,b) => a-b);
    console.log(`answer : ${answer}`);
    var tmp = [];
    // tmp 빈 배열을 만들고
    // 중첩 반복문을 통해서 반복을 통해 a,b를 더한다
    // 더한 값을 tmp에 push해주고, tmp를 내림차순 정렬한다(pop하기 쉽게 하기 위해서)
    // tmp.length >=2 라면 내림차순 정렬된 tmp 를 서로 비교해 같을 경우 tmp를 pop 해준다.
    for(var i = 0 ; i < answer.length ; i ++){
        for(var j = 1 ; j < answer.length-1 ; j ++){
            s = answer[i] + answer[j];
            //tmp 안에 s와 같은 값이 들어있는지 확인( 없을경우 tmp에 넣는다.)
            tmp.push(s);
        }
    }
    
    // 계산된 tmp값을 tmp.length만큼 반복해, 오름차순 청렬 + a =!
    for(var i = 0 ; i < tmp.length ; i ++){
        for(var j = 0 ; j < tmp.length ; j ++){
            tmp = tmp.filter((a,b) => a !== b);
        }
    }
    tmp = tmp.sort((a,b) => a-b);
    console.log(`tmp : ${tmp}`);
    // return tmp;
}

function load(){
    var result = solution([2,1,3,4,1]);
    console.log(result);
}
function init(){
    load();
}
init();