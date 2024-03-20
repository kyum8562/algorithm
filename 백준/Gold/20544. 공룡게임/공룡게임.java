import java.io.*;
import java.util.*;

class Main {
    static final int DIVIDE_NUM = 1_000_000_007;
    static int N, ans;
    static int[] map;
    static int[][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ans = 0;
        map = new int[N];
        dp = new int[N][4][3][3];

        System.out.println(dfs(1, 0, 0, 0));
    }

    private static long dfs(int depth, int prevHeight2Cnt, int cactusCnt, int isTwoHeight) {
        if (prevHeight2Cnt == 2 || cactusCnt > 2) return 0;
        if (depth == N) return isTwoHeight;

        if (dp[depth][prevHeight2Cnt][cactusCnt][isTwoHeight] != 0)
            return dp[depth][prevHeight2Cnt][cactusCnt][isTwoHeight];

        return dp[depth][prevHeight2Cnt][cactusCnt][isTwoHeight]
                = (int)((
                        dfs(depth + 1, prevHeight2Cnt + 1, cactusCnt + 1, 1) +
                        dfs(depth + 1, 0, cactusCnt + 1, isTwoHeight) +
                        dfs(depth + 1, 0, 0, isTwoHeight)
                        )% DIVIDE_NUM);
    }
}