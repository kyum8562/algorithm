function solution(arr) {
    // Insertin Sorting
    // 적절한 부분에 삽입을 하면서 정렬을 한다는 뜻을 담은 정렬방식
    // Bubble Sorting과 시간 복잡도 O(N*N)가 동일하다는 점 때문에
    // 느리고 직관적인 정렬 방식이라고 불린다.
    // stable한 정렬방식이다.

    for (let i = 0; i < arr.length; i ++) {
        // 현재 인덱스에 해당하는 arr 값을 tmp에 넣음
        let tmp = arr[i], j;
        
        // 직전 인덱스
        // let idx = i - 1;
        // //직전값이 크다면
        // while (idx >= 0 && arr[idx] > tmp) {
        //     // 현재값에 직전값을 넣어줌
        //     arr[idx + 1] = arr[idx];
        //     // 직전값 인덱스 하나 감소 후 다시 비교
        //     idx -= 1;
        // }
        // arr[idx + 1] = tmp;

        for(j = i-1 ; j >= 0 ; j --){
            if(arr[j] > tmp) arr[j+1] = arr[j]; 
            else break;
        }
        arr[j+1] = tmp;
        console.log(arr);
    }
    return arr;
}

console.log(solution([9, 3, 5, 7, 1]));