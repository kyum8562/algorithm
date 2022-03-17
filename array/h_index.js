// H-Index
// n개의 배열 내에서 h이상인 원소가 h개일 때의 최댓값 원소의 인덱스를 구해라.

    function solution(citations) {
        citations = citations.sort((a, b) => b - a);
        let i = 0;
        while (i + 1 <= citations[i]) {
            i++;
        }
        return i;
}

function init(){
const s3 = solution([3, 0, 6, 1, 5]);
console.log(s3);
}

init();
