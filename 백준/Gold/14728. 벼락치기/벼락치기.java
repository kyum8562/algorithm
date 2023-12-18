import java.io.*;
import java.util.*;

public class Main {
//    static int N, ans;
    static int[] map;
    static boolean[][] v;
    static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] T = new int[N + 1];
        int[] G = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            G[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = K; j >= T[i]; j--)
                dp[j] = Math.max(dp[j], dp[j - T[i]] + G[i]);
        }
        System.out.println(dp[K]);
    }
}