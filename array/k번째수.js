//K번째수
function solution1(array, commands) {
    var answer = [];

    for(var i = 0 ; i < commands.length ; i ++){
            var arr = array.slice(commands[i][0]-1,commands[i][1]);
            var sortArr = arr.sort((a,b) => {return a-b});
            console.log(`sortArr ${i} : ${sortArr}`);
            answer.push(sortArr[commands[i][2]-1]);
    }

    return answer;
}

function init() {
    var s1 = solution1([1, 5, 2, 6, 3, 7, 4], [[2, 5, 3], [4, 4, 1], [1, 7, 3]]);
    console.log(s1);
}

init();

// var dum = 'abc de';
// var dum2 = dum.substring(0,1);
// console.log(dum2);