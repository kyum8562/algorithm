import java.io.*;
import java.util.*;

public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            N = Integer.parseInt(br.readLine()); // 정점의 개수

            pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

            for(int i = 1 ;i <= N ; i ++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                if(a == 1){ // 삽입 연산
                    pq.offer(Integer.parseInt(st.nextToken()));
                }
                else{ // 삭제 연산
                    if(pq.size() >= 1)
                        sb.append(pq.poll());
                    else
                        sb.append(-1);
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}