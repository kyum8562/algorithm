import java.io.*;
import java.util.*;

public class Solution {
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> left, right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 정점의 개수
            int A = Integer.parseInt(st.nextToken());

            
            // left의 개수는 right 보다 1많도록 설정
            left = new PriorityQueue<>((o1, o2) -> o2 - o1); // 최대 힙
            right = new PriorityQueue<>(); // 최소 힙(DEFAULT)

            left.offer(A);

            int res = 0;
            for(int i = 1 ;i <= N ; i ++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                int midVal = left.peek();

                // a와 b 모두 중앙값 보다 작을 때
                if(midVal > a && midVal > b){
                    left.offer(a);
                    left.offer(b);
                    right.offer(left.poll());
                }
                // a와 b 모두 중앙값 보다 클 때
                else if(midVal < a && midVal < b){
                    right.offer(a);
                    right.offer(b);
                    left.offer(right.poll());
                }
                else{
                    if(a < b){
                        left.offer(a);
                        right.offer(b);
                    }
                    else{
                        left.offer(b);
                        right.offer(a);
                    }
                }

                res = (res + left.peek()) % 20171109;
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}