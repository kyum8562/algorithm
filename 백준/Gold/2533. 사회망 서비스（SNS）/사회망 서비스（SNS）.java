import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    static int[][] dp;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ans = 0;

        dp = new int[N+1][2];
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

        recur(1, 0);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void recur(int cur, int prev) {
        dp[cur][1] = 1; // 현재 노드가 얼리어답터일 경우

        for(int next: list[cur]){
            if(next == prev) continue;

            recur(next, cur);
            dp[cur][0] += dp[next][1];
            dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }
}