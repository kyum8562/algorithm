import java.io.*;
import java.util.*;

class Main {
    static int N, ans;
    static Map<Integer, Integer> map = new LinkedHashMap<>();
    static int[][] arr, dp;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ans = Integer.MIN_VALUE;

        arr = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans = Math.max(ans, recur(i, j));
            }
        }

        System.out.println(ans);
    }

//    private static void recur(int r, int c, int sum) {
//
//        ans = Math.max(ans, sum);
//
//        for(int d = 0 ; d < 4 ; d ++){
//            int nr = r + dr[d];
//            int nc = c + dc[d];
//
//            if(!isValid(nr, nc) || v[nr][nc]) continue;
//            if(arr[r][c] >= arr[nr][nc]) continue;
//
//            v[nr][nc] = true;
//            recur(nr, nc, sum+1);
//            v[nr][nc] = false;
//        }
//    }

    private static int recur(int r, int c) {

        if(dp[r][c] != 0) return dp[r][c];

        dp[r][c] = 1;

        for(int d = 0 ; d < 4 ; d ++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(!isValid(nr, nc)) continue;
            if(arr[r][c] >= arr[nr][nc]) continue;

            dp[r][c] = Math.max(dp[r][c], recur(nr, nc)+1);
            recur(nr, nc);
        }

        return dp[r][c];
    }

    private static boolean isValid(int nr, int nc) {
        return(nr>=0 && nr<N && nc>=0 && nc<N);
    }
}