import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1 << 30;
    static int N, K;
    static int[] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        dp = new int[K+1];

        Arrays.fill(dp, -1);

        for(int i = 0 ; i < N ; i ++)
            arr[i] = Integer.parseInt(br.readLine());

        int res = recur(K);
        System.out.println(res == INF ? -1 : res);
    }
    private static int recur(int sum) {
        if(sum < 0) return INF;
        if(sum == 0) return 0;

        if(dp[sum] != -1) return dp[sum];

        int ret = INF;

        for(int i = 0 ; i < N ; i ++){
            ret = Math.min(ret, recur(sum - arr[i]) + 1);
        }

        return dp[sum] = ret;
    }
}