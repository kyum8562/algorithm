import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N;
    static Integer[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        dp = new Integer[N+1];

        sb.append(recur(N)).append("\n");
        System.out.print(sb);
    }

    private static int recur(int cur) {
        if(cur == -1) return -1;

        if(dp[cur] != null) return dp[cur];

        int ret = INF;
        int tmp;

        String curS = String.valueOf(cur);
        for (int i = 0; i < curS.length(); i ++) {
            if(curS.charAt(i) == '0') continue;

            for (int j = i + 1; j <= curS.length(); j++) {
                tmp = Integer.parseInt(curS.substring(i, j));

                if (tmp == cur) continue;

                if (recur(cur - tmp) == -1)
                    ret = Math.min(ret, tmp);
            }
        }

        if(ret == INF) ret = -1;

        return dp[cur] = ret;
    }
}