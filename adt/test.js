function solution(arr){

    for(let i = 0 ; i < arr.length-1; i ++){
        let idx = i;
        // 현재인덱스+1부터 배열마지막까지의 최솟값 인덱스 찾음
        for(let j = i+1 ; j < arr.length; j++){
            if(arr[j] < arr[idx]) idx = j;
        }

        // if(arr[i] > arr[idx]){
        //     let tmp = arr[i];
        //     arr[i] = arr[idx];
        //     arr[idx] = tmp;
        // }
        [arr[i], arr[idx]] = [arr[idx], arr[i]];
    }

    return arr;
}


console.log(solution([5, 11, 7, 23, 15]));
