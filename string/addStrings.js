function solution(a,b){
    // 정수로된 문자열 a, b를 더하는 문제
    // 조건 : integer나 float로 변환 금지

    var tmp = [];
    var carry = 0;
    var aLen = a.length-1, bLen = b.length-1;
    var up = 0;
    for(var i = 0 ; i < Math.max(a.length,b.length) ; i ++){
        if(aLen !== -1 && bLen !== -1){
            carry = a[aLen]/1 + b[bLen]/1 + up;
        }
        else if(aLen === -1){
            carry = b[bLen]/1 + up;
        }
        else if(bLen === -1){
            carry = a[aLen]/1 + up;
        }
        
        up = Math.floor(carry/10); // 0
        var stay = carry%10; // 3
        tmp[i] = stay;
        
        if(aLen >=0) aLen --;
        if(bLen >=0) bLen --;

        if(aLen < 0 && bLen < 0){
            return tmp = tmp.reverse();
        }
    }

}

function load(){
    var result = solution('3850','273');
    console.log(result);
}
function init(){
    load();
}
init();