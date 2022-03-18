//조이스틱
// 결과값이 N자리수이면, 시작을 자릿수에 맞게 A로 세팅(소문자는 없음)
// ▲ - 다음 알파벳
// ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
// ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
// ▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
// 만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
function solution5(name) {
    var answer = 0;
    let min  = name.length -1;

    for(var i = 0 ; i < name.length ; i ++){
        let tmp = name.charCodeAt(i);
        // console.log(tmp);

        // 65~90의 중간인 78(기준)보다 작으면 그냥 카운트
        if(tmp < 78){
            answer += tmp%65;
        }
        // 78(기준)보다 크면 91에서 tmp를 빼준다.
        else{
            answer += 91-tmp;
        }
        // 좌우 이동 인덱스
        let nextIdx = i+1;
        while(nextIdx < name.length && name.charCodeAt(nextIdx) === 65)
            nextIdx += 1;

            min = Math.min(min, (i*2) + name.length - nextIdx);
    }
    answer += min;
    return answer;
}



// console.log(solution5("JEROEN"));
console.log(solution5("BBBAAAAAABA"));
// console.log(solution5("JAN"));