import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[][][][] dp;
    static int[] dr = {0, 1};
    static int[] dc = {1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T ; t ++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            for(int i = 0 ; i < N ; i ++){
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = s.charAt(j) == '.' ? 0 : 1;
                }
            }

            dp = new int[N][N][2][K+1];
            for(int i = 0 ; i < N ; i ++){
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < 2; k++)
                        Arrays.fill(dp[i][j][k], -1);
                }
            }

            sb.append(recur(1, 0, 1, K)+recur(0, 1, 0, K)).append("\n");
        }
        System.out.print(sb);
    }
    private static int recur(int r, int c, int curD, int sparePoint) {
        if(!isValid(r, c) || arr[r][c] == 1 || sparePoint < 0) return 0;

        if(r == N-1 && c == N-1){
            return dp[r][c][curD][sparePoint] = 1;
        }

        if(dp[r][c][curD][sparePoint] != -1)
            return dp[r][c][curD][sparePoint];

        dp[r][c][curD][sparePoint] = 0;

        // 현재 방향이 동쪽일 때
        if(curD == 0){
            if(sparePoint > 0){
                dp[r][c][curD][sparePoint] += recur(r, c+1, curD, sparePoint) + recur(r+1, c, 1-curD, sparePoint-1);
            }
            else{
                dp[r][c][curD][sparePoint] += recur(r, c+1, curD, sparePoint);
            }
        }
        // 현재 방향이 남쪽일 때
        else{
            if(sparePoint > 0){
                dp[r][c][curD][sparePoint] += recur(r+1, c, curD, sparePoint) + recur(r, c+1, 1-curD, sparePoint-1);
            }
            else{
                dp[r][c][curD][sparePoint] += recur(r+1, c, curD, sparePoint);
            }
        }

        return dp[r][c][curD][sparePoint];
    }

//    for(int d = 0 ; d < 2 ; d ++){
//        int nr = r + dr[d];
//        int nc = c + dc[d];
//
//        if(curD == d){
//            tmp += recur(nr, nc, d, sparePoint-1);
//        }
//        else
//            tmp += recur(nr, nc, d, sparePoint);
//    }
    private static boolean isValid(int r, int c) {
        return (r>=0 && r<N && c>=0 && c<N);
    }

//    private static int recur(int a, int b) {
//        if(dp[a][b] != -1)
//            return dp[a][b];
//
//        int ret = 1 << 30;
//        for(int i = a ; i < b ; i ++)
//            ret = Math.min(ret, recur(a, i) + recur(i+1, b));
//
//        return dp[a][b] = ret + prefixSum[b+1] - prefixSum[a];
//    }
}