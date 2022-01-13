function solution(s){
    
    // key -value 방식으로 풀이

    // 각 인덱스에 해당하는 문자열을 배열로 바꾸고 
    //오름차순 정렬 뒤 문자열로 다시 넣어줌
    // var input = s[2].split('');
    // console.log(input);
    // var input1 = input.sort();
    // input1 = input1.join('');
    // console.log(input1);

    var obj = {'abc' : '',
                'cde' : {},
                'adc' : {},
                'ab' : {}
            };
    // var j = s.length;
    for(var i = 0; i < s.length ; i++){
        var arr = s[i].split('');
           var a = arr.sort().join('');
           for(var j = 0 ; j < obj.length ; j++){
               if(Object.keys(obj)[j] === a){
                   obj = a;
               }

           }
        s.pop();
    }

    console.log(Object.keys(obj));
    console.log(obj[0]);
    return obj;
}

function load(){
    var result = solution(["abc", "cde", "bca", "adc", "dec", 'ba']);
    console.log(result);
}
function init(){
    load();
}
init();