import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dp;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        dp = new int[N+1];
        list = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i ++)
            list[i] = new ArrayList<>();

        for(int i = 0 ; i < N-1 ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        recur(R, 0);

        for(int i = 0 ; i < Q ; i ++){
            int tgt = Integer.parseInt(br.readLine());
            sb.append(dp[tgt]).append("\n");
        }

        System.out.print(sb);
    }

    private static void recur(int cur, int prev) {
        dp[cur] = 1;

        for(int next: list[cur]){
            if(next == prev) continue;

            recur(next, cur);

            dp[cur] += dp[next];
        }
    }
}