function solution(a){
    //a  = [ 1, 0, 2, 2, 0, 1, 2, 1, 0 ] 가 주어졌을 때
    //a' = [ 0, 0, 0, 1, 1, 1, 2, 2, 2 ] 를 출력하면 된다.

    // sort 정렬을 사용한다면 O(n*logN)이 나오므로
    // O(n) 
    console.log(a);
    idx = a[0];
    idx++;
    console.log(idx);
}

function load(){
    var result = solution([0, 5, 0, 7, 6, 3]);
    console.log(result);
}
function init(){
    load();
}
init();
