function solution(arr){
    // Bubble Sorting
    // 일반적인 brute Force 방식의 Sorting
    // stable한 정렬방식 : 문자와 숫자가 섞여있는채로 정렬하면 알맞게 정렬됨
    // [7a 5a 5b 7b 3c] --- bubble sorting --> [3c 5a 5b 7a 7b]
    // 시간 복잡도 : O(N*N), 정렬 중에서는 느린 편이다.
    var arr = arr;
    var tmp = 0 ;
    for(var i = 0 ; i < arr.length-1 ; i ++){
        for(var j = 0 ; j < arr.length-i-1 ; j ++){
            if( arr[j] > arr[j+1] ){
                [arr[j], arr[j+1]] = [arr[j+1], arr[j]];
            }
        }
    }
    return arr;

}

function load(){
    var result = solution(['7a', '5a', '5b', '7b', '3c']);
    console.log(result);
}
function init(){
    load();
}
init();