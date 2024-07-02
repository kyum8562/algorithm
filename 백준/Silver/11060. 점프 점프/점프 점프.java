import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1 << 30;
    static int N, ans;
    static int[] arr, dp;
    static boolean[] v;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ans = INF;

        arr = new int[N+1];
        dp = new int[N+1];
        v = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = INF;
        }

        ans = dfs(1);

        System.out.print(ans == INF ? -1 : ans);
    }

    private static int dfs(int cur) {
        if(cur > N) return INF;
        else if(cur == N) return 0;

        if(dp[cur] != INF) return dp[cur];

        int num = arr[cur];

        int ret = INF;
        for(int i = 1 ; i <= num ; i ++)
            // 오른쪽으로만 가기 때문에 방문 처리 필요 x
            ret = Math.min(ret, dfs(cur+i) + 1);

        return dp[cur] = ret;
    }
}
