function solution(arr){
    // Selecting Sort
    // 배열의 0번째 인덱스부터 순회를 하면서 인덱스 값들 중 최솟값과 swap을 하는 정렬 방식.
    // 시간 복잡도 : O(N*N)
    // Unstable한 정렬이다.
    var idx2 = 0;
    for(var i = 0 ; i < arr.length ; i ++){
        
        var minNum = arr[i+1];
        // i+1부터 arr.length까지의 최솟값 찾기
        for(var j = i+1 ; j < arr.length-1 ; j ++){
            if(minNum > arr[j+1]){
                minNum = arr[j+1];
                idx2 = j+1;
            }
        }
        // arr.length의 -2와 -1 인덱스를 비교해서 바꾸어준다.
        if(i === arr.length-2){
            if(arr[i] > arr[i+1]){
                var tmp = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = tmp;    
            }
        }
        // 최솟값과 arr[i]를 비교해 arr[i]가 크다면 서로 swap
        else if(arr[i] > minNum){
            var tmp = arr[i];
            arr[i] = minNum;
            arr[idx2] = tmp;
        }
    }
    return arr;

    
}
console.log(solution(['3', '5', '9', '1', '7']));