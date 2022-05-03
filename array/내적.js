function solution(a, b, answer = 0){
    // a.forEach((v,i) => answer += v*b[i]);
    // return answer;

    // 2
    return a.reduce((acc, _, i) => acc += a[i]*b[i], 0);
}


console.log(solution([1,2,3,4], [-3,-1,0,2]));
console.log(solution([-1,0,1], [1,0,-1]));
