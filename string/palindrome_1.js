function solution(s){
    // 회문인지 아닌지를 비교해주는 문제
    
    var answer = 0;
    var p1 = 0;
    var p2 = s.length-1;
    for(var i = 0 ; i < s.length ; i ++){
        if(p1 === p2){
            return (answer * 2 +1) ? true : false;
        }
        if(s[p1] === s[p2]){
            answer ++;
            p1++;
            p2--;
        }
        else{ return false; }
    }

    return answer;
}

function load(){
    var result = solution('abcba');
    console.log(result);
}
function init(){
    load();
}
init();