function buildPatternTable(word){
    const patternTable = [0];
    let prefixIdx = 0;
    let suffixIdx = 1;

    while(suffixIdx < word.length){
        if(prefixIdx === 0){
            patternTable[suffixIdx] = 0;
            suffixIdx++;
        }
        else if(word[prefixIdx] === word[suffixIdx]){
            patternTable[suffixIdx] = prefixIdx + 1;
            suffixIdx ++;
            prefixIdx ++;
        }
        else {
            prefixIdx = patternTable[prefixIdx - 1];
        }
        
    }
    return patternTable;
}

function solution(text, word){

    let textIdx = 0;
    let wordIdx = 0;

    const patternTable = buildPatternTable(word);
    console.log(patternTable);

    while (textIdx < text.length) {
        if (text[textIdx] === word[wordIdx]) {
            if (wordIdx === word.length - 1) {
                return textIdx - word.length + 1;
          }
            wordIdx++;
            textIdx++;
        } 
        else if (wordIdx > 0) {
            wordIdx = patternTable[wordIdx - 1];
        } 
        else {
            wordIdx = 0;
            textIdx++;
        }
    }
    
      return -1;
}


function load(){
    var result = solution("asdfasdfasfasdfasdfasdfadsfaeeee", "aeeee");
    console.log(result);
}
function init(){
    load();
}
init();
