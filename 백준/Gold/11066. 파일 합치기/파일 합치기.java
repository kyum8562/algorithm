import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, prefixSum;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T ; t ++){
            int N = Integer.parseInt(br.readLine());

            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N ; i ++)
                arr[i] = Integer.parseInt(st.nextToken());

            prefixSum = new int[N+1];
            dp = new int[N][N];

            for(int i = 1 ; i <= N ; i ++)
                prefixSum[i] = prefixSum[i-1] + arr[i-1];

            for(int i = 0 ; i < N ; i ++)
                Arrays.fill(dp[i], -1);

            for(int i = 0 ; i < N ; i ++){
                for(int j = 0 ; j < N ; j ++){
                    if(i == j)
                        dp[i][j] = 0;
                    else if(i+1 == j)
                        dp[i][j] = arr[i] + arr[j];
                }
            }

            sb.append(recur(0, N-1)).append("\n");
        }
        System.out.print(sb);
    }

    private static int recur(int a, int b) {
        if(dp[a][b] != -1)
            return dp[a][b];

        int ret = 1 << 30;
        for(int i = a ; i < b ; i ++)
            ret = Math.min(ret, recur(a, i) + recur(i+1, b));

        return dp[a][b] = ret + prefixSum[b+1] - prefixSum[a];
    }
}