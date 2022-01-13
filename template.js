function makeFailureArray(target){
    var i = 1;
    let failureArray = [];
    let target1 = target.split('');
    // for( var i = 0 ; i < target.length ; i ++){
    //     failureArray[i] = -1;
    // }
    failureArray.length = target.length;
    failureArray.fill(-1);
    
    while(i < target.length){
        let idx = 1 + failureArray[i-1];
        if(target[idx] === target[i]){
            failureArray[i] = idx; 
            i ++;
        }
        else if(target[idx] !== target[i]){
            failureArray[i] = -1;
            i ++;

        }
    }
    return failureArray;

}
function solution(text, target){
    var textIdx = 0; 
    var targetIdx = 0;
    const failureArray = makeFailureArray(target);
    console.log(failureArray);
    console.log(text);
    console.log(target);
    
    while(textIdx < text.length && targetIdx < target.length){
        if(target[targetIdx] === text[textIdx]){
            textIdx++;
            targetIdx ++;
        }
        else if(target[targetIdx] !== text[textIdx]){
            textIdx++;
            targetIdx = failureArray[targetIdx] +1;
        }
    }
    console.log ( textIdx, targetIdx);
    return (targetIdx === target.length ) ? textIdx-targetIdx : -1;

    // return answer;
}

function load(){
    var sameTextFristIndex = solution("aabcacabcabcacab", "abcabcacab");
    console.log(`sameTextFristIndex : ${sameTextFristIndex}`);
}
function init(){
    load();
}
init();