import java.io.*;
import java.util.*;

class Main {
    static final int MOD = 100_000;
    static int R, C;
    static int[][][][] dp;
    static int[] dr = {0, 1};
    static int[] dc = {1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dp = new int[R+1][C+1][2][2];

        // 3번째 인자(현재 방향): 1 북 0 동
        // 4번쨰 인자(변경 가능여부): 1 가능 0 불가능
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                for (int k = 0; k < 2; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }
        int res = (recur(1, 1, 0, 0) + recur(1, 1, 1, 0)) % MOD;
        System.out.println(res);
    }

//    private static void recur(int r, int c, int prevD, int cnt, int dist) {
//        if(!isValid(r, c)) return;
//
//        if(r == R && c == C){
//            if(min > dist){
//                min = dist;
//                ans = 1;
//            }
//            else if(min == dist){
//                ans ++;
//            }
//            return;
//        }
//
//        for(int d = 0 ; d < 2 ; d ++){
//            int nr = r + dr[d];
//            int nc = c + dc[d];
//
//            if(prevD != d){
//                if(cnt == 0) continue;
//                recur(nr, nc, d, 0, dist+1);
//            }
//            else{
//                recur(nr, nc, d, cnt+1, dist+1);
//            }
//        }
//    }

    private static int recur(int r, int c, int curD, int isChange) {
        if(!isValid(r, c))
            return 0;

        if(r == R && c == C)
            return dp[r][c][curD][isChange] = 1;

        if(dp[r][c][curD][isChange] != -1)
            return dp[r][c][curD][isChange];

        dp[r][c][curD][isChange] = 0;

//        for(int d = 0 ; d < 2 ; d ++){
//            int nr = r + dr[d];
//            int nc = c + dc[d];
//
//            // 현재 방향이랑 가야할 방향이 다를 때
//            if(curD != d){
//                if(isChange == 0) continue;
//                dp[r][c][curD][isChange] += recur(nr, nc, d, 1) + 1;
//            }
//            // 현재 방향이랑 가야하 방향이 같을 때
//            else{
//                dp[r][c][curD][isChange] += recur(nr, nc, d, 1) + 1;
//            }
//        }

        if (curD == 1) {
            if (isChange == 1) {
                dp[r][c][curD][isChange] = (dp[r][c][curD][isChange] + recur(r, c + 1, curD, isChange) + recur(r + 1, c, 1 - curD, 1 - isChange)) % MOD;
            } else {
                dp[r][c][curD][isChange] = (dp[r][c][curD][isChange] + recur(r, c + 1, curD, 1 - isChange)) % MOD;
            }
        } else {
            if (isChange == 1) {
                dp[r][c][curD][isChange] = (dp[r][c][curD][isChange] + recur(r + 1, c, curD, isChange) + recur(r, c + 1, 1 - curD, 1 - isChange)) % MOD;
            } else {
                dp[r][c][curD][isChange] = (dp[r][c][curD][isChange] + recur(r + 1, c, curD, 1 - isChange)) % MOD;
            }
        }

        return dp[r][c][curD][isChange];
    }

    private static boolean isValid(int nr, int nc) {
        return(nr>=1 && nr<=R && nc>=1 && nc<=C);
    }
}