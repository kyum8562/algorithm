function solution(arr) {
    // Insertin Sorting
    // 적절한 부분에 삽입을 하면서 정렬을 한다는 뜻을 담은 정렬방식
    // Bubble Sorting과 시간 복잡도 O(N*N)가 동일하다는 점 때문에
    // 느리고 직관적인 정렬 방삭이라고 불린다.
    // stable한 정렬방식이다.
    var arr = arr;

    for (var i = 0; i < arr.length; i++) {
        var tmp = arr[i];
        var idx = i - 1;

        while (0 <= idx && tmp < arr[idx]) {
            arr[idx + 1] = arr[idx];
            idx = idx - 1;
        }
        arr[idx + 1] = tmp;
    }
    return arr;
}

function load() {
    var result = solution([9, 3, 5, 7, 1]);
    console.log(result);
}
function init() {
    load();
}
init();