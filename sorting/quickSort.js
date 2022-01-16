function solution(arr){
    // Quick Sort :partitioning을 이용한 알고리즘
    // 배열에서 랜덤하게 3을 선택하여 피벗으로 설정하고, 그 수를 맨 마지막 인덱스의 값인 1과
    // swap을 해준다. 배열의 0번째 인덱스에 p1을 설정하고 피벗을 제외한 맨 마지막 인덱스를 p2로
    // 설정한다. p1이 피벗보다 크면 멈추고, 작으면 오른쪽으로 한 칸 이동
    // p2는 p1과 반대로, 피벗보다 크면 왼쪽으로 한 칸 이동하고 작으면 멈춘다.
    // p1과 p2가 더 이상 움직일 곳이 없으면, p1과 p2를 swap 해준다.
    // 이를 반복하며 진행하면 p1, p2가 더 이상 움직일 곳이 없게 되고
    // 기준이 되는 수의 왼쪽은 피벗보다 작은값이, 오른쪽은 피벗보다 큰 값이 위치하게 된다.
    // 그 경우 피벗과 기준이 되는 수를 swap해주면서 마무리가 된다.
    // 이후 피벗 기준 왼쪽/오른쪽을 각각 Quick Sort를 진행하게 되면 전체 배열이 정렬이 되며
    // 알고리즘이 종료된다.
    // 시간 복잡도는 O(N*logN)이며 Unstable한 알고리즘이다.
    var arr = arr;
    var startIdx = 0;
    var lastIdx = arr.length -1;

    


}

function load(){
    var result = solution(['2', '1', '4', '7', '5', '3']);

    console.log(result);
}
function init(){
    load();
}
init();