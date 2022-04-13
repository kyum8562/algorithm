/*
뮤직비디오
DVD에는 총 N개의 곡이 들어가는데,
DVD에 녹화할 떄는 라이브에서의 순서가 그대로 유지되어야 한다.
즉, 1번 노래와 5번노래를 같은 DVD에 녹화하기 위ㅐ서는
1번과 5번사이의 모든 노래도 같은 DVD에 녹화해야 한다.
또한 한 노래를 쪼개서 두 개의 DVD에 녹화하면 안된다.

M개의 DVD에 모든 동영상을 녹화하려고 하며
M개는 모두 같은 크기여야 한다.

DVD의 최소용량 크기 출력해라

ex)3개의 DVD용량이 17분짜리이면 (1,2,3,4,5) (6,7) (8,9)로
3개의 DVD로 녹음을 할 수 있다. 17분 용량보다 작은 용량으로는
3개의 DVD에 모든 영상을 녹화할 수 없다. 
*/
function cnt(mid, arr){
    let cnt = 1, sum = 0;
    for(let x of arr){
        if(sum+x > mid){
            cnt ++;
            sum = x;
        }
        else sum += x;
    }
    return cnt;
}

function solution(n, arr){
    let answer;
    let lt = Math.max(...arr);
    let rt = arr.reduce((a,b) => a+b, 0);

    while(lt <= rt){
        let mid = parseInt((lt + rt)/2);
        if(cnt(mid, arr) <= n){
            answer = mid;
            rt = mid -1;
        }
        else lt = mid +1;
    }
   
    return answer;
}


console.log(solution(3, [1, 2, 3, 4, 5, 6, 7, 8, 9]));
//기댓값 : 17