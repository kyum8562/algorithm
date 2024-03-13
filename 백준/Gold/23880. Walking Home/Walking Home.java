import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] arr;
    static int[][][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T ; t ++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            arr = new char[N][N];
            for(int i = 0 ; i < N ; i ++){
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = s.charAt(j);
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
        if(!isValid(r, c) || arr[r][c] == 'H' || sparePoint < 0) return 0;

        if(r == N-1 && c == N-1){
            return dp[r][c][curD][sparePoint] = 1;
        }

        if(dp[r][c][curD][sparePoint] != -1)
            return dp[r][c][curD][sparePoint];

        dp[r][c][curD][sparePoint] = 0;

        if(curD == 0)
            dp[r][c][curD][sparePoint] += recur(r, c+1, curD, sparePoint) + (sparePoint > 0 ? recur(r+1, c, 1-curD, sparePoint-1) : 0);
        else
            dp[r][c][curD][sparePoint] += recur(r+1, c, curD, sparePoint) + (sparePoint > 0 ? recur(r, c+1, 1-curD, sparePoint-1) : 0);

        return dp[r][c][curD][sparePoint];
    }
    private static boolean isValid(int r, int c) {
        return (r>=0 && r<N && c>=0 && c<N);
    }
}