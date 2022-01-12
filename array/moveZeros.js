function solution(){
    // 배열 내에 0이 있을 경우, 맨 마지막으로 이동해 주는 문제이다.
    // A = [0, 5, 0, 7, 6, 3]에서 두 개의 0을 이동해
    // A' = [ 5, 7, 6, 3, 0, 0] 값이 나오게 하는 것이다.
    // (0을 제외한 숫자의 순서는 바뀌지 말아야 한다)

    const a = [0, 5, 0, 7, 6, 3];
    console.log(`A : ${a}`);
    let p = 1;
    let p2 = 0;
    for ( var i = 0 ; i < a.length ; i ++){
        let tmp = 0;
        //0 숫자
        if(a[p2] === 0 && a[p] !== 0){
            if(p >= a.length) {return a};
            tmp = a[p];
            a[p] = a[p2];
            a[p2] = tmp;
            p++;
            p2++;
        }
        //0 0
        else if(a[p2] === 0 && a[p] === 0){
            p ++;
        }
        console.log(`${i} : ${a}`);

    }
    return a; 
}
050763
5007
// 5 0 0 7

function load(){
    var result = solution();
    console.log(result);
}
function init(){
    load();
}
init();