import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] arr, prefixSum;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        prefixSum = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            prefixSum[i+1] = prefixSum[i] + arr[i];
        }

        K = Integer.parseInt(br.readLine());

        dp = new int[3+1][N+1];
        for(int i = 0 ; i < 4 ; i ++)
            Arrays.fill(dp[i], -1);

        sb.append(recur(0, N)).append("\n");
        System.out.print(sb);
    }

    private static int recur(int miniTrainCnt, int curIdx) {
        if(miniTrainCnt == 3 || curIdx == 0)
            return 0;

        if(dp[miniTrainCnt][curIdx] != -1)
            return dp[miniTrainCnt][curIdx];

        dp[miniTrainCnt][curIdx] = 0;

        if(K > curIdx)
            return 0;

        int res1 = recur(miniTrainCnt, curIdx-1);
        int res2 = recur(miniTrainCnt+1, curIdx-K) + prefixSum[curIdx] - prefixSum[curIdx-K];
        return dp[miniTrainCnt][curIdx] = Math.max(res1, res2);


    }
}