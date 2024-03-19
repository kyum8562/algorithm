import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        Node[] arr = new Node[N];
        int[] dp = new int[N];

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i] = new Node(a, b);
        }

        Arrays.sort(arr);

        // LIS와 동일하게 구해줌 -> 최장 증가 부분 수열의 길이를 구해주고 N에서 빼주면, 문제의 답(빼야되는 최소 개수) 도출
        for(int i = 0 ; i < N ; i ++){ // 기준
            for(int j = 0 ; j < i ; j ++){ // 기준보다 작은 인덱스
                if(arr[j].r >= arr[i].r) continue;

                dp[i] = Math.max(dp[i], dp[j]+1);
            }

            ans = Math.max(ans, dp[i]);
        }
        System.out.println(N - ans - 1);
    }
    static class Node implements Comparable<Node>{
        int l, r;
        public Node(int l, int r){
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Node o){
            return this.l - o.l;
        }
    }
}