function checkSpace(s){
    var space = /\s/;
    return (s.search(space)) ?  false : true ;
}
function checkSpecialS(s){
    var specialS = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
    return (specialS.test(s)) ? true : false;
}

function solution(s){
    // 회문인지 아닌지를 비교해주는 문제
    // + 조건 : 문자열(s) 사이에 공백이나 특수문자가 들어갔을 경우 무시하고 진행

    var answer = 0;
    var p1 = 0;
    var p2 = s.length-1;
    var cntSpecialAndSpace = 0;
    var result = answer-cntSpecialAndSpace;
    for(var i = 0 ; i < s.length ; i ++){
        if(p1 === p2){
            return (((result) * 2 +1) %2 !== 0)?
            (((result) * 2 +1) ? true : false):
            (((result) * 2) ? true : false);
        }
        else if(p1 > p2){
            return (result);
        }

        if((checkSpecialS(s[p1]) || checkSpace(s[p1]))){
            p1 ++;
            cntSpecialAndSpace ++;
        }
        else if((checkSpecialS(s[p2]) || checkSpace(s[p2]))){
            p2 --;
            cntSpecialAndSpace ++;
        }
        else if(s[p1] === s[p2]){
            if(p2-p1 <= 1){
                p2--;
            }
            else{
                answer ++;
                p1++;
                p2--;
            }

        }
        else{ return false; }
    }
    return (result);
}

function load(){
    var result = solution('abcc b?a');
    console.log(result);
}
function init(){
    load();
}
init();