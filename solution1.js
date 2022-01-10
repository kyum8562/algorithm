// Q21. 문자열 내림차순으로 배치하기
function q21(a){
    // (1)
    var s = a.split('');
    var tmp = '';
    for(var i = 0; i < s.length-1; i++){
        for(var j = 0; j < s.length-1; j++){
            if(s[j] < s[j+1]){
                tmp = s[j+1];
                s[j+1] = s[j];
                s[j] = tmp;
            }
        }
    }
    return s.join('');
    return a.split('').sort().reverse().join('')

    // (2)
    return a.split('').sort((a,b) => {
        if( a > b) return -1;
        if( a < b) return 1;
        return 0;
    }).join('');
}

// Q22. 문자열 다루기 기본
function q22(s){
    // 문자열 s 길이가 4 or 6이고, 숫자로만 구성돼 있는지 확인하는 함수
    return (s.length === 4 || s.length === 6) && /^[0-9]+$/.test(s);
    // ^ : 시작
    // [0-9] : 0~9 까지의 숫자
    // + : 반복, 앞의 문자가 1개 이상인 경우
    // $ : 종료
    // test() : 주어진 문자열이 정규 표현식을 만족하는지 여부(T/F)
}

// Q23. 문자열 내 p와 y의 개수 비교
function q23(s){
    var arr = s.split('');
    var pCount = 0;
    // var yCount = 0;
    // for( var i = 0 ; i < arr.length ; i ++) {
    //     if( arr[i] === 'P' || arr[i] === 'p') pCount++;
    //     if( arr[i] === 'Y' || arr[i] === 'y') yCount++;
    // }    
    // if(pCount === yCount || (pCount == 0 && yCount == 0)){
    //     return true;
    // }
    // else{
    //     return false;
    // }

    // (2)
    console.log(s.toUpperCase().split('Y'));
    console.log(s.toUpperCase().split('P'));
    return s.toUpperCase().split('Y').length === s.toUpperCase().split('P').length;

    // (pCount === yCount || (pCount == 0 && yCount == 0)) ? true : false ;
}

// Q24. 문자열 내 마음대로 정렬하기
function q24(strings, n){
    // 문자열이 들어있는 배열과 숫자를 입력받고,
    // 배열 문자열에서 숫자에 해당하는 인덱스를 기준으로 오름차순 정렬
    var answer = strings.sort((a, b) => {
        if(a[n] > b[n]) return 1;
            if(a[n] < b[n]) return -1;
            if(a[n] === b[n]){
                if(a>b) return 1;
                if(a<b) return -1;
                return 0;
            }
    });
    return answer ;
}

// Q25. 두 정수 사이의 합
function q25(a, b){
    var answer = 0;
    var n1 = Math.min(a,b);
    var n2 = Math.max(a,b); 
    for(var i = n1; i < n2+1; i++){
        answer += i;
    }
    return answer;
}

// Q26. 나누어 떨어지는 숫자 배열
function q26(arr, divisor){
    //array의 각 element 중 divisor로 나누어 떨어지는 값을
    // 오룸차순으로 정렬한 배열을 반환하는 함수
    // 나누어 떨어지는 element가 하나도 없다면 배열에 -1 담아 반환

    var answer = [];
    for(var i = 0 ; i < arr.length ; i ++){
        if( arr[i] % divisor === 0 ){
            answer.push(arr[i]);
        }
    }
    if(answer.length === 0){
        answer.push(-1);
    }
    console.log(answer);
    return answer.sort((a,b) => a-b);
}

// Q27. 같은 숫자는 싫어
function q27(arr){
    // 주어진 배열 arr의 각 원소는 0~9사이의 숫자로 이루어져있다.
    // 배열 arr에서 연속적으로 나타는 숫자는 하나만 남기고
    // 전부 제거하려고 한다.
    // 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소의
    // 순서를 유지해야 한다.

    // (1)
    var answer = [];
    for ( var i = 0 ; i < arr.length ; i ++) {
        var count = 0;
        var j = i+1;
        while(j < arr.length){
            if( arr[i] === arr[j]){
            count ++;
            j++;
        }
        else{ break;}
        }
        
        // if(answer.indexOf(arr[i]) == -1){
        // }
        answer.push(arr[i]);
        i += count
    } 

    return answer;

    // (2)
    var answer = [];
    answer.push(arr[0]);
    for ( var i = 1 ; i < arr.length ; i ++) {
        var count = 0;
        if( arr[i-1] !== arr[i]){
            answer.push(arr[i]);
        }
    }
    return answer;

    // (3)
    return arr.filter((val,index) => val != arr[index+1]);
}

// Q28. 가운데 글자 가져오기
function q28(s){
    var answer = '';
    if(s.length%2 === 0){
        answer = s[Math.floor(s.length/2)-1]+ s[Math.floor(s.length/2)]
        return answer;
    }
    else{
        answer = s[Math.floor(s.length/2)]
        return answer;
    }
}

// Q29. 시저암호

function load(){
    // var r = q21("Zbcdefg");
    // var r = q22("a234");
    // var r = q23("PPoooyY");
    // var r = q24(["sun","bed","car"], 1);
    // var r = q25(3,5);
    // var r = q26([5,9,7,10], 5);
    // var r = q27([4,4,4,4,4,4,4,4,3,3,4,4,4,4,4]);
    // var r = q28("ab");
    var r = q29("AB");

    console.log(r);
}

function init(){
    load();
}

init();