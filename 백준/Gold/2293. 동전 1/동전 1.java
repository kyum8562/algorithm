import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        int[] dp = new int[K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());

        }
        dp[0] = 1;

        // dp[i] = j (i는 목적지, j는 횟수)
        for (int i = 1; i <= N; i++) {
            for (int j = arr[i]; j <= K; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }


        System.out.println(dp[K]);
    }
}