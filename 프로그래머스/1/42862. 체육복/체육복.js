function solution(n, lost, reserve) {
    var answer = 0;
    let cnt = 0;
    const arr = new Array(n).fill(1);
    for(let i = 0; i < lost.length ; i ++){
        arr[lost[i]-1] -= 1; 
    }
    for(let i = 0; i < reserve.length ; i ++){
        arr[reserve[i]-1] += 1; 
    }
    console.log(arr);
    
    for(let i = 0 ; i < arr.length ; i ++){
        // 체육복이 없는 인덱스
        if(arr[i] == 0){
            // 먼저 앞사람이 체육복이 2개인지 확인, 2개라면 나누어 줌
            if(arr[i-1] ==2){
                arr[i-1] = 1;
                arr[i] = 1;
            }
            // 앞사람x, 뒷사람이 체육복이 2개인지 확인, 2개라면 나누어 줌
            else if(arr[i+1] ==2){
                arr[i+1] = 1;
                arr[i] = 1;
            }
        } 
    }
    arr.map(a => {if(a >=1) cnt++;})
    
    return cnt;
}