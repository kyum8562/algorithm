function arrCul(){

}
function binaryArray(){

}

function secretMap(n, arr1, arr2){
    // 비밀지도

    // 네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다.
    // 그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야한다.
    // 다행이 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.
    
    // 1. 지도는 한 변의 길이가 n 인 정사각형 배열 형태로, 각 칵은 공백(" "), 벽("#") 두 종류이다.
    // 2. 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다.
    // 각각 지도 1과 지도 2라고 하자. 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서 벽
    // 이다. 지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
    // 3. 지도 1과 지도 2는 각각 정수 배열로 암호화 되어있다.
    // 4. 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0 으로 부호화 했을 때
    // 얻어지는 이진수에 해당하는 값의 배열이다.

    // 네오가 프로도의 비상금을 손에 넣을 수 있또록, 비밀지도의 암호를 해독하는 작업을
    // 도와줄 프로그램을 작성하라.

    // 입력으로 지도의 한 변의 크기 n 과 2개의 정수 배열 arr1, arr2가 들어온다.
    // 1 <= n <= 16, arr1, arr2는 길이 n인 정수 배열로 주어진다.
    // 정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n 이하이다.
    // 즉 0 <= x <= (2의 n제곱) -1 을 만족한다.

    // 원래의 비밀지도를 해독하여 '#', 공백으로 구성된 문자열 배열로 출력하라.
    
    console.log(`arr1 : ${arr1} \narr2 : ${arr2}`);
    var answer2 = [];

    // 10 > 2 진수 변환
    for(var i = 0 ; i < n ; i ++){
        arr1[i] = arr1[i].toString(2);
        arr2[i] = arr2[i].toString(2);
        if(arr1[i].length < n){ arr1[i] = "0".repeat(n - arr1[i].length) +arr1[i].toString(2)}; 
        if(arr2[i].length < n){ arr2[i] = "0".repeat(n - arr2[i].length) +arr2[i].toString(2)}; 
        
        
    }
    console.log(`Change arr1 : ${arr1}`);
    console.log(`Change arr2 : ${arr2}`);
    
    for(var i = 0 ; i < n ; i ++){
        var answer = "";
        for(var j = 0 ; j < arr1.length ; j ++){
            answer += parseInt(arr1[i][j])|| parseInt(arr2[i][j]) ? '#' : ' ';
            answer2[i] = answer;
        }
    }
    console.log(answer2);

    return answer2;    

}
function load(){
    var r = secretMap(6, [46, 33, 33, 22, 31, 50], [27, 56, 19, 14, 14, 10]);
    console.log(r);
}
function init(){
    load();
}
init();
