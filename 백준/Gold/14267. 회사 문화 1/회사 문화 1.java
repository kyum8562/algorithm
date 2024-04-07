import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dp;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        // 직속 상사 번호
        // 1: 사장, 사장의 직속상관은 없으므로 -1
        dp = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a == -1) continue;
            list[a].add(i);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dp[a] += b;
//            Queue<Integer> q = new ArrayDeque<>();
//            q.offer(a);
//            ans[a] += b;
//            while(!q.isEmpty()){
//                int curr = q.poll();
//
//                for(int next: list[curr]){
//                    ans[next] += b;
//                    q.offer(next);
//                }
//            }
        }

        dfs(1);

        for (int i = 1; i <= N; i++)
            sb.append(dp[i]).append(" ");
        System.out.println(sb);
    }

    private static void dfs(int curr) {
        for(int next: list[curr]){
            dp[next] += dp[curr];
            dfs(next);
        }
    }
}