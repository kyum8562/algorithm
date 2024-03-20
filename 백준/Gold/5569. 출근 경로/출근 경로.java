import java.io.*;
import java.util.*;

class Main {
    static final int MOD = 100_000;
    static int R, C;
    static int[][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 3번째 인자(현재 방향): 1 북 0 동
        // 4번쨰 인자(변경 가능여부): 1 가능 0 불가능
        dp = new int[R + 1][C + 1][2][2];

        for (int i = 2; i <= R; i++)
            dp[i][1][0][0] = 1;
        for (int i = 2; i <= C; i++)
            dp[1][i][1][0] = 1;

        for (int i = 2; i <= R; i++) {
            for (int j = 2; j <= C; j++) {
                dp[i][j][0][0] = (dp[i-1][j][0][0] + dp[i-1][j][0][1]) % MOD;
                dp[i][j][0][1] = dp[i-1][j][1][0];

                dp[i][j][1][0] = (dp[i][j-1][1][0] + dp[i][j-1][1][1]) % MOD;
                dp[i][j][1][1] = dp[i][j-1][0][0];
            }
        }

        int ans = 0;
        for(int i = 0 ; i < 2 ; i ++){
            for(int j = 0 ; j < 2 ; j ++)
                ans += dp[R][C][i][j];
        }

        System.out.println(ans % MOD);
    }
}