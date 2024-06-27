import java.io.*;
import java.util.*;

public class Main {
    static int N, S, M;
    static int[] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        dp = new int[N+1][M+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0 ; i <= N ; i ++){
            Arrays.fill(dp[i], -2);
        }

        int tmp = recur(0, S);
        System.out.println(tmp);
    }
    private static int recur(int depth, int val) {
        if(val < 0 || val > M) return -1;
        if(depth == N) return val;

        if(dp[depth][val] != -2) return dp[depth][val];

        int ret = -1;

        ret = Math.max(ret, recur(depth + 1, val + arr[depth+1]));
        ret = Math.max(ret, recur(depth + 1, val - arr[depth+1]));

        return dp[depth][val] = ret;
    }
}
