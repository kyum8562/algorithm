const binaryArray = (arr) => {for(var i = 0 ; i < arr.length ; i ++){arr[i] = arr[i].toString(2);}return arr}

function arrCul(arr1, arr2, n){
    var answer2 = [];

    for(var i = 0 ; i < n ; i ++){
        var answer = "";
        for(var j = 0 ; j < n ; j ++){
            answer += parseInt(arr1[i][j])|| parseInt(arr2[i][j]) ? '#' : ' ';
            answer2[i] = answer;
        }
    }
    return answer2;
}
function format(arr, n){
    for(var i = 0 ; i < n ; i ++){
        if(arr[i].length < n){ arr[i] = "0".repeat(n - arr[i].length) +arr[i].toString(2)};         
    }
}

function secretMap(n, arr1, arr2){
    
    format(binaryArray(arr1), n);
    format(binaryArray(arr2), n);
    console.log(arr1);
    console.log(arr2);
    
    return arrCul(arr1, arr2, n);    
}
function load(){
    var r = secretMap(6, [46, 33, 33, 22, 31, 50], [27, 56, 19, 14, 14, 10]);
    console.log(r);
}
function init(){
    load();
}
init();
