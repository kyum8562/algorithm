// 배열의 첫 원소를 사용하지 않음 + binary search tree 관계
// 왼쪽 자식의 인덱스 : 부모 index * 2
// 오른쪽 자식의 인덱스 : 부모 index * 2 + 1
// 부모 인덱스 : Math.floor(자식 index / 2)


class minHeap {
    constructor() {
      this.heap = [null];
    }

    print() {
        console.log(this.heap);
    }

    getMin() {
        return this.heap[1] ? this.heap[1] : null;
    }
    
    swap(a,b) {
        [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]];
    }

    push(value){
        this.heap.push(value);
        let curIdx = this.heap.length -1;
        // Math.floor 역할 ' >> 0 ' : 소수점 버림
        let parIdx = (curIdx /2 ) >> 0;

        while(curIdx > 1 && this.heap[parIdx] > this.heap[curIdx]){
            this.swap(parIdx, curIdx)
            curIdx = parIdx;
            parIdx = (curIdx / 2 ) >> 0;
        }
    }

    pop(){
        const min = this.heap[1]; // 루트노드 idx

        if(this.heap.length <= 2) this.heap = [null];

        // 배열의 마지막 원소를 pop하고 root 위치에 값을 넣는다.
        else this.heap[1] = this.heap.pop(); 

        let curIdx = 1;
        let leftIdx = curIdx * 2;
        let rightIdx = curIdx * 2 + 1;
        
        // 왼쪽 자식이 없다 => 오른쪽 자식도 없다 => 루트노드만 있다 => 바로 반환
        if(!this.heap[leftIdx]) return min;

        // 오른쪽 자식이 없다 => 왼쪽 자식만 있다.
        if(!this.heap[rightIdx]){
            if(this.heap[leftIdx] < this.heap[curIdx]) {
                this.swap(leftIdx, curIdx);
            }
            return min;
        }

        // 왼쪽, 오른쪽 자식 둘다 있을 경우
        // 현재 노드가 왼쪽 오른쪽보다 큰지 작은지 검사하며 반복
        while(this.heap[leftIdx] < this.heap[curIdx] || this.heap[rightIdx] < this.heap[curIdx]) {
            // 자식 노드 중 작은 값을 현재 노드와 스왑
            const minIdx = this.heap[leftIdx] > this.heap[rightIdx] ? rightIdx : leftIdx ;
            this.swap(minIdx, curIdx);
            curIdx = minIdx;
            leftIdx = curIdx * 2;
            rightIdx = curIdx * 2 + 1;
        }
        
        return min;
    }
}

  
function main() {
    // heap 배열 생성
    const heap = new minHeap();
    // 1~ 10 heap 배열에 넣어줌
    for (let i = 10; i > 0; i--) {
      heap.push(i);
    }
    //heap 배열 출력
    heap.print();

    // 최소힙 진행
    while (heap.getMin()) {
      console.log("pop : " + heap.pop());
      heap.print();
    }
  }
  
  main();

