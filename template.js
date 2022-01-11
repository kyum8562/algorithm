function validation(){
    const pV = price <1 || price >2500 || price %1 !==0 ? "[price] " : '';
    const printVali = pV +  mV + cV + "유효성이 적절하지 않습니다.";
    if(pV.length !== 0 ) console.log(printVali);
}

function solution(){
    validation();
}

function load(){
    var result = solution();
    console.log(result);
}
function init(){
    load();
}
init();