import java.io.*;
import java.util.*;

class Main {
    static int N;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp = new long[31][31];
        while(true){
            N = Integer.parseInt(br.readLine());

            if(N == 0) break;

            sb.append(recur(N, 0)).append("\n");
        }

        System.out.print(sb);
    }

    private static long recur(int defCnt, int brokenCnt) {
        if(defCnt < 0 || brokenCnt < 0) return 0;
        if(defCnt == 0 && brokenCnt == 0) return 1;

        if(dp[defCnt][brokenCnt] != 0) return dp[defCnt][brokenCnt];

        long ret = 0;

        // 약을 쪼개어 먹는 경우
        ret += recur(defCnt-1, brokenCnt + 1);
        // 쪼개지 않을 경우(쪼갠거 먹을 경우)
        ret += recur(defCnt, brokenCnt - 1);

        return dp[defCnt][brokenCnt] = ret;
    }
}