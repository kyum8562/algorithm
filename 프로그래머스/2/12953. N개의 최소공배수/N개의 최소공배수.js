function solution(arr) {
    return arr.reduce((ans, cur) => getLCM(ans, cur), 1)
}
function getLCM(ans, cur){
    return ans*cur/getGCD(ans, cur);
}
function getGCD(ans, cur){
    if(ans%cur == 0) return cur;
    else return getGCD(cur, ans%cur);
}