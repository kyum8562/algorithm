
function solution(){
    // 오름차순 정렬이 되어있는 배열 a
    let answer = 0;
    const a = [ 1, 3, 5, 6, 7, 15, 20 ];
    const goal = a[5];
    //일반적인 search를 할 경우 시간 복잡도는 O(n)
    //bianry search를 할 경우 -> O(logN)
    // left와 right를 배열의 양 끝에 두고, 가운데 인덱스를 pivot으로 잡는다
    let left = 0;
    let right = a.length-1;
    
    for(var i = 0 ; i < Math.sqrt(a.length) ; i ++){
        let pivot = Math.floor((left+right)/2);
        ( a[pivot] > goal ) ? right = pivot : ( a[pivot] < goal ) ? left = pivot : answer = a[pivot];
    }

    return answer;
}

function load(){
    var result = solution();
    console.log(result);
}
function init(){
    load();
}
init();