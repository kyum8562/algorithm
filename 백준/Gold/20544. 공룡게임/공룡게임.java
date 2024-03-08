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
        dp = new int[N][4][3][3];

        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < 4 ; j ++){
                for(int k = 0 ; k < 3 ; k ++){
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

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

    /**
     * @param depth: 현재 위치
     * @param prevHeight2Cnt: 이전까지 연속해서 넘은 높이가 2인 장애물 수
     * @param cactusCnt: 이전까지 연속해서 넘은 선인장 수
     * @param isTwoHeight: 높이가 2인 선인장을 넘었는지 여부
     * @return N의 위치까지 도달한 수
     */
    private static long dfs(int depth, int prevHeight2Cnt, int cactusCnt, int isTwoHeight) {
        if (prevHeight2Cnt == 2 || cactusCnt > 2) return 0;
        if (depth == N) return isTwoHeight;

        if (dp[depth][prevHeight2Cnt][cactusCnt][isTwoHeight] != -1)
            return dp[depth][prevHeight2Cnt][cactusCnt][isTwoHeight];

        return dp[depth][prevHeight2Cnt][cactusCnt][isTwoHeight]
                = (int)((
                        dfs(depth + 1, prevHeight2Cnt + 1, cactusCnt + 1, 1) +
                        dfs(depth + 1, 0, cactusCnt + 1, isTwoHeight) +
                        dfs(depth + 1, 0, 0, isTwoHeight)
                        )% DIVIDE_NUM);
    }
}