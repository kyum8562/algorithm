// Q31. 다트 게임
function dartGame(r){
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
    var tmp = 0;
    var tmp2 = 0;
    var r1_s = 0, r2_s = 0, r3_s = 0;
    var arr = [];
    console.log(`r = ${r}`);
    // 결과값 분해
    for(var i = 0 ; i < r.length; i ++){
        
        // arr 배열에 2개의 결과값이 들어갔다면 나머지 넣어줌
        if(arr.length === 2){
            arr[2] = r.substring(tmp2);
        }
        
        else if(Number(r[i+2]) || parseInt(r[i+2]) === 0 ){
        arr[tmp] = r.substring(tmp2, i+2);
        tmp2 = i+2;
        tmp ++;
        i = tmp2-1;    
        }
    }
    console.log(`arr : ${arr}`);

    for(var i = 0 ; i < arr.length ; i ++){
        for(var j = 0 ; j < arr[i].length ; j ++){
            if(i === 0){
                if(Number(arr[i][j+1]) === 0){
                    r1_s += parseInt(arr[i][j] + arr[i][j+1]);
                    j++;
                }
                else if(Number(arr[i][j])) r1_s += parseInt(arr[i][j]);
                else if(arr[i][j] === 'D') r1_s **= 2;
                else if(arr[i][j] === 'T') r1_s **= 3;
                
                else if(arr[i][j] === '*') r1_s *= 2;
                else if(arr[i][j] === '#') r1_s *= (-1);
            }
            else if(i === 1){
                if(Number(arr[i][j+1]) === 0){
                    r2_s += parseInt(arr[i][j] + arr[i][j+1]);
                    j++;
                }
                else if(Number(arr[i][j])) r2_s += parseInt(arr[i][j]);
                else if(arr[i][j] === 'D') r2_s **= 2;
                else if(arr[i][j] === 'T') r2_s **= 3;
                
                else if(arr[i][j] === '*') r2_s *= 2, r1_s *= 2;
                else if(arr[i][j] === '#') r2_s *= (-1);
            }
            else if(i ===2){
                if(Number(arr[i][j+1]) === 0){
                    r3_s += parseInt(arr[i][j] + arr[i][j+1]);
                    j++;
                }
                else if(Number(arr[i][j])) r3_s += parseInt(arr[i][j]);
                else if(arr[i][j] === 'D') r3_s **= 2;
                else if(arr[i][j] === 'T') r3_s **= 3;
                
                else if(arr[i][j] === '*') r3_s *= 2, r2_s *= 2;
                else if(arr[i][j] === '#') r3_s *= (-1);
            }
        }
    }
    console.log(`r1_s : ${r1_s} r2_s : ${r2_s} r3_s : ${r3_s}`);
    var answer = parseInt(r1_s) + parseInt(r2_s) + parseInt(r3_s) ;
    return answer;
}



function load(){
    var result = dartGame("10D10S#10S");
    console.log(result);
}
function init(){
    load();
}
load();