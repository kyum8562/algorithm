/*
졸업선물
현재 예산으로 최대 몇명의 학생에게 선물을 사줄 수 있는지 구해라
상품 하나를 50% 할인해서 살 수 있는 1장의 쿠폰을 가지고있다(배송비는 할인X)
items에는 상품에 대한 [비용, 배송비]가 들어있다.
*/
function solution(money, items){
    // 비용+배송비를 기준으로 오름차순 정렬
    items.sort((a,b) => {
        return (a[0]+a[1]) - (b[0]+b[1]);
    })
    console.log(items);

    let answer = 0;
    for(let i = 0 ; i < items.length ; i ++){
        let cnt = 0;
        let discountItem = items[i][0]/2 + items[i][1];
        let myMoney = money - discountItem;
        console.log(`discountItem : [${items[i]}], cal : ${discountItem}`);
        console.log(`money : ${myMoney}`);
        cnt ++;

        for(let j = 0 ; j < items.length ; j ++){
            if(myMoney >= items[j][0]+items[j][1] > money) break;
            if(j !== i && myMoney >= items[j][0]+items[j][1]){
                myMoney -= items[j][0]+items[j][1];
                cnt ++;
            }
        }
        console.log(`myMoney : ${myMoney}`);
        if(answer < cnt) answer = cnt;
    }
   
    return answer;
}


console.log(solution(28, [[6, 6], [2, 2], [4, 3], [4, 5], [10, 3]]));
// 기댓값 : 4
