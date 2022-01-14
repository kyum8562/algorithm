function solution(s) {

    // key -value 방식으로 풀이

    console.log(s);
    // var tmp = [];
    // for(var i = 0; i < s.length ; i++){
    //     var arr = s[i].split('').sort();
    //     var a = arr.sort().join('');
    //     tmp[i] = a;
    // }
    // tmp.sort();
    // tmp = Array.from(new Set(tmp));
    // console.log(tmp);
    // for(var i = 0; i < s.length ; i++){

    // }

    var obj = {
        'abc': [],
        'cde': [],
        'acd': [],
        'ab': []
    };
    // var j = s.length;
    for (var i = 0; i < s.length; i++) {
        var arr = s[i].split('').sort();
        var a = arr.sort().join('');
        for (var j = 0; j < s.length; j++) {
            if (Object.keys(obj)[j] === a) {
                obj[Object.keys(obj)[j]][Object.values(obj)[j].length] = s[i];
                j += 5;
            }
        }

    }
    return obj;
}

function load() {
    var result = solution(["abc", "cde", "bca", "adc", "dec", 'ba']);
    console.log(result);
}
function init() {
    load();
}
init();