function solution(){
    // Find Pivot Index
    // Sliding 알고리즘(array를 간단하게 순환한다라는 개념) 적용한 문제
    // a[i]의 왼쪽에 있는 값의 합 = 오른쪽에 있는 값의 합일 때의 인덱스를 리턴해라.
    // 단, 어떠한 경우에도 될 수 없다면 -1을 리턴해라.

    // Brute Force 방식을 이용한다면 시간 복잡도가 O(n*n)이므로 적절하지 않음
    // Sliding 알고리즘 방식은 시간 복잡도가 O(n)이다.
 
    // 주어진 배열 a
    const a = [1, 8, 2, 9, 2, 3, 6];

    // 배열 a의 sum을 right sum에 넣어주고, 각 변수 선언 및 초기화
    let left_sum = 0;
    let right_sum = a.reduce((a,b) => a+b);
    
    // 조건문을 a.length 만큼 반복
    for(var pivot = 0 ; pivot < a.length ; pivot ++){
        
        // left_sum !== right_sum 일 때의 조건
        if(left_sum !== right_sum ){
            right_sum -= a[pivot];
            if(pivot !==0 ) {left_sum += a[pivot-1]};
        }
        if(left_sum === right_sum){
            return pivot;
        }
    }
    return -1;
}

const a = a.map(([a,b]) => a < b ? [b, a] : [a, b])
a.forEach(element => {
    
});

function load(){
    var result = solution();
    console.log(result);
}
function init(){
    load();
}
init();