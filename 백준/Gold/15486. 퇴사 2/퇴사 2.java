import java.io.*;
import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, ans;
    static int[] dp;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
//        ans = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;

        map = new int[N+2][2];
        dp = new int[N+2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        // 바텀업
        for(int day = 1 ; day <= N+1 ; day ++){
            max = Math.max(max, dp[day]);

            // 다음으로 넘어갈 날
            int next = day + map[day][0];

            // 다음으로 넘어갈 날이 유효범위라면
            if(N+1 >= next)
                dp[next] = Math.max(dp[next], max + map[day][1]);
        }

        System.out.println(dp[N+1]);

        // 백트래킹 or 탑다운
//        System.out.println(dfs(1));
    }

// [1단계: 백트래킹]
    //    private static void dfs(int day, int sum) {
//        if(day > N) return;
//
//        if(day == N){
//            ans = Math.max(ans, sum);
//            return;
//        }
//
//        dfs(day + map[day][0], sum + map[day][1]);
//        dfs(day + 1, sum);
//    }

    // [2단계: 리턴으로 바꾸기] -> 해당 날짜에서 최대 얼마를 버는지
//    private static int dfs(int day) {
//        if (day > N) return -(1 << 30);
//        if (day == N) return 0;
//
//        return Math.max(dfs(day + map[day][0]) + map[day][1], dfs(day + 1));
//    }

    // [3단계: 탑다운 DP로 바꾸기] -> 해당 날짜에서 최대 얼마를 버는지
//    private static int dfs(int day) {
//        if (day > N) return -(1 << 30);
//        if (day == N) return 0;
//
//        if(dp[day] != -1) return dp[day];
//
//        return dp[day] = Math.max(dfs(day + map[day][0]) + map[day][1], dfs(day + 1));
//    }
}