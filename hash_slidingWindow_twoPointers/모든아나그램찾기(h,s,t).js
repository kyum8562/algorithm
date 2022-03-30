/*
모든 아나그램 찾기
S문자열에서 T문자열과 아나그램이 되는 S문자열의 부분문자열의 개수를
구하는 프로그램을 작성하세요(아나그램 판별시 대소문자가 구분됩니다.)

첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력된다.
S문자열의 길이는 10,000을 넘지 않으며, T문자열 길이 <= S문자열의 길이
*/
function compareMap(map1, map2){
    if(map1.size !== map2.size) return false;
    for(let [key, value] of map1){
        if(!map2.has(key) || map2.get(key) !== value) return false;
    }
    return true;
}
function solution(s, t){
    let answer = 0;
    let lt = 0;

    // t의 tHash 생성
    let tHash = new Map();
    for(let i = 0 ; i < t.length ; i ++){
        if(tHash.has(t[i])) tHash.set(t[i], tHash.get(t[i]) +1);
        else tHash.set(t[i], 1);
    }

    // s의 sHash 생성, s의 t.length-1 길이까지 인덱스를 미리 넣어줌
    // (슬라이딩 윈도우를 위해)
    let sHash = new Map();
    for(let i = 0 ; i < t.length-1 ; i ++){
        if(sHash.has(s[i])) sHash.set(s[i], sHash.get(s[i]) +1);
        else sHash.set(s[i], 1);
    }
    
    // two pointers & sliding window
    for(let rt = t.length-1 ; rt < s.length ; rt ++){
        if(sHash.has(s[rt])) sHash.set(s[rt], sHash.get(s[rt]) +1);
        else sHash.set(s[rt], 1);

        if(compareMap(sHash, tHash)){
            answer++;
        } 
        sHash.set(s[lt], sHash.get(s[lt])-1);
        if(sHash.get(s[lt]) === 0) sHash.delete(s[lt]);    
        lt++;
    }
    return answer;

}
console.log(solution('bacaAacba', 'abc'))