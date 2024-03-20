import java.io.*;
import java.util.*;

class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][M+1];
        int[][] dp = new int[N+1][M+1];
        int[][] lf = new int[M+2][2];

        for(int i = 1 ; i <= N ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= M ; j ++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        // 기저
        dp[1][1] = arr[1][1];

        for(int i = 2 ; i <= M ; i ++)
            dp[1][i] = dp[1][i-1] + arr[1][i];

        for(int i = 2 ; i <= N ; i ++){

            // 왼쪽 -> 오른쪽
            lf[0][0] = dp[i-1][1];
            for(int j = 1 ; j <= M ; j ++)
                lf[j][0] = Math.max(dp[i-1][j], lf[j-1][0]) + arr[i][j];

            // 오른쪽 -> 왼쪽
            lf[M+1][1] = dp[i-1][M];
            for(int j = M ; j >= 1 ; j --)
                lf[j][1] = Math.max(dp[i-1][j], lf[j+1][1]) + arr[i][j];

            for(int j = 1 ; j <= M ; j ++)
                dp[i][j] = Math.max(lf[j][1], lf[j][0]);
        }

        System.out.println(dp[N][M]);

    }
}