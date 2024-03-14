import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int T, W;
    static int[] arr;
    static Integer[][][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new int[T+1];
        for(int i = 1 ; i <= T ; i ++)
            arr[i] = Integer.parseInt(br.readLine()) - 1;

        dp = new Integer[T+1][2][W+1];

        System.out.print(recur(1, 0, W));
    }

    private static int recur(int depth, int curP, int availCnt) {
        if(availCnt < 0) return -(1 << 30);

        if(depth == T+1) return 0;

        if(dp[depth][curP][availCnt] != null)
            return dp[depth][curP][availCnt];

        dp[depth][curP][availCnt] = 0;

        // 떨어지는 위치와 현재 위치가 같을경우
        if(arr[depth] == curP)
            dp[depth][curP][availCnt] = recur(depth+1, curP, availCnt) + 1;
        else{
            // 이동해서 먹을 거라면
            int res = Math.max(recur(depth+1, 1-curP, availCnt-1) + 1, recur(depth+1, curP, availCnt));
            dp[depth][curP][availCnt] = Math.max(dp[depth][curP][availCnt], res);
        }

        return dp[depth][curP][availCnt];
    }
}