function solution(arr){   
    var pivot = arr.length-2;
    var p1 = 0;
    var p2 = arr.length-1;
    console.log(`prevArr : ${arr}`);

    var tmp = arr[pivot];
    arr[pivot] = arr[p2];
    arr[p2] = tmp;
    console.log(`currArr : ${arr}`);

    tmp = p2;
    p2 = pivot;
    pivot = tmp;

    for( var i = 0 ; i < arr.length ; i ++){
        // p1
        if(arr[p1] < arr[pivot]){
            p1++;
        }
        else{
            break;
        }
        
    }
    return p1;
}   

console.log(solution(['3', '5', '9', '1', '2', '4', '7']));