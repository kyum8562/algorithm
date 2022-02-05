# 우선순위 큐

물건 데이터를 자료구조에 넣었다가 가치가 높은 물건부터 꺼내서 확인해야하는경우

스택(가장 나중에 삽입된 데이터 먼저추출)

큐(가장 먼저 삽입된 데이터 추출)

우선순위큐(가장 우선순위가 높은 데이터 추출)

## 우선순위 구현 방법

1. 단순히 리스트를 이용해서 구현(각각 데이터를 확인한다음에 제일 큰 값 호출)
   이 경우 삽입시간 O(1) 삭제시간 O(N)
2. 힙을 이용하여 구현
   이 경우 삽입시간, 삭제시간 O(logN) (최악의 경우도 동일)

# 힙(heap)

힙은 완전 이진트리 자료구조의 일종이다.
완전 이진트리는 루트노드, 왼쪽 자식노드, 오른쪽 자식노드 순으로 데이터가 삽입되는 트리

## 최소힙 최대힙

힙은 최소힙과 최대힙이 있다.
최소힙은 루트노드가 가장 작은 값을 가지며, 값이 가장 작은 데이터가 우선적으로 제거된다.
최대힙은 최소힙의 반대.

## 삽입

리스트의 맨 마지막에 삽입을 하며, 부모 노드와의 값을 비교해 현재노드의 값이 작다면 swap을 진행한다.

## 삭제

힙에서 원소가 제거 될 떄는 가장 마지막 노드가 루트 노드의 위치에 오도록 한다.
