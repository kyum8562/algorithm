# [Gold III] Sleeping in Class - 24620 

[문제 링크](https://www.acmicpc.net/problem/24620) 

### 성능 요약

메모리: 24292 KB, 시간: 292 ms

### 분류

브루트포스 알고리즘, 수학, 정수론, 누적 합

### 제출 일자

2024년 2월 14일 16:18:04

### 문제 설명

<p>Bessie the cow was excited to recently return to in-person learning! Unfortunately, her instructor, Farmer John, is a very boring lecturer, and so she ends up falling asleep in class often.</p>

<p>Farmer John has noticed that Bessie has not been paying attention in class. He has asked another student in class, Elsie, to keep track of the number of times Bessie falls asleep in a given class. There are $N$ class periods ($1\le N\le 10^5$), and Elsie logs that Bessie fell asleep $a_i$ times ($0\le a_i\le 10^6$) in the $i$-th class period. The total number of times Bessie fell asleep across all class periods is at most $10^6$.</p>

<p>Elsie, feeling very competitive with Bessie, wants to make Farmer John feel like Bessie is consistently falling asleep the same number of times in every class -- making it appear that the issue is entirely Bessie's fault, with no dependence on Farmer John's sometimes-boring lectures. The only way Elsie may modify the log is by combining two adjacent class periods. For example, if $a=[1,2,3,4,5],$ then if Elsie combines the second and third class periods the log will become $[1,5,4,5]$.</p>

<p>Help Elsie compute the minimum number of modifications to the log that she needs to make so that she can make all the numbers in the log equal.</p>

### 입력 

 <p>Each input will contain $T$ ($1\le T\le 10$) test cases that should be solved independently.</p>

<p>The first line contains $T$, the number of test cases to be solved. The $T$ test cases follow, each described by a pair of lines. The first line of each pair contains $N$, and the second contains $a_1,a_2,\ldots,a_N$.</p>

<p>It is guaranteed that within each test case, the sum of all values in $a$ is at most $10^6$. It is also guaranteed that the sum of $N$ over all test cases is at most $10^5$.</p>

### 출력 

 <p>Please write $T$ lines of output, giving the minimum number of modifications
Elsie could perform to make all the log entries equal for each case.

					</p>

