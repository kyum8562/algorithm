import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] dp;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new int[N+1];
        for(int i = 1 ; i <= N ; i ++)
            map[i] = Integer.parseInt(st.nextToken());

        dp = new long[N+1];

        dp[1] = map[1];
        long ans = map[1];

        for(int i = 1 ; i <= N ; i ++){
            dp[i] = Math.max(dp[i-1] + map[i], map[i]);
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}