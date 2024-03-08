import java.io.*;
import java.util.*;

class Main {
    static final int DIVIDE_NUM = 1_000_000_007;
    static int N, ans;
    static int[] map;
    static int[][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        ans = 0;
        map = new int[N];
        dp = new int[N][3 + 1][2 + 1][2];

        System.out.println(dfs(1, 0, 0, 0));
    }

    // [1. 백트래킹]
//    private static void dfs(int depth, int curHeight, int cactusCnt, boolean isTwoHeight) {
//        if(curHeight >= 4 || cactusCnt > 2) return;
//        if(depth == N){
//            if(isTwoHeight) ans ++;
//            return;
//        }
//
//        dfs(depth+1, curHeight+2, cactusCnt+1,true);
//        dfs(depth+1, curHeight+1, cactusCnt+1, isTwoHeight);
//        dfs(depth+1, 0, 0, isTwoHeight);
//    }
    // [2. 리턴]
//    private static int dfs(int depth, int curHeight, int cactusCnt, boolean isTwoHeight) {
//        if(curHeight >= 4 || cactusCnt > 2) return 0;
//        if(depth == N){
//            if(isTwoHeight) return 1;
//            return 0;
//        }
//
//        return dfs(depth+1, curHeight+2, cactusCnt+1,true) +
//        dfs(depth+1, curHeight+1, cactusCnt+1, isTwoHeight) +
//        dfs(depth+1, 0, 0, isTwoHeight);
//    }
    // [3. 탑다운 DP]
    private static long dfs(int depth, int curHeight, int cactusCnt, int isTwoHeight) {
        if (curHeight >= 4 || cactusCnt > 2) return 0;
        if (depth == N) return isTwoHeight;

        if (dp[depth][curHeight][cactusCnt][isTwoHeight] != 0)
            return dp[depth][curHeight][cactusCnt][isTwoHeight];

        return dp[depth][curHeight][cactusCnt][isTwoHeight]
                = (int) ((
                            dfs(depth + 1, curHeight + 2, cactusCnt + 1, 1) +
                            dfs(depth + 1, curHeight + 1, cactusCnt + 1, isTwoHeight) +
                            dfs(depth + 1, 0, 0, isTwoHeight)
                        ) % DIVIDE_NUM);
    }
}