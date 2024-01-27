import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
//    static final int INF = Integer.MIN_VALUE;
    static int[][] prefixSum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        prefixSum = new int[N+1][M+1];

        // 가로 누적합 구하기
        for(int i = 1 ; i <= N; i ++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j ++) {
                int tmp = Integer.parseInt(st.nextToken());
                prefixSum[i][j] = prefixSum[i][j-1] + tmp;
            }
        }

        // (가로 누적합 기반) 세로 누적합 구하기
        for(int i = 1 ; i <= N; i ++){
            for (int j = 1; j <= M; j ++) {
                prefixSum[i][j] += prefixSum[i-1][j];
            }
        }

        // 브루트포스 최댓값 구하기
        int ans = Integer.MIN_VALUE;
        for(int i = 1 ; i <= N; i ++){
            for (int j = 1; j <= M; j ++) {
                for (int k = i; k <= N; k++) {
                    for (int l = j; l <= M; l++) {
                        ans = Math.max(ans, (prefixSum[k][l] - prefixSum[k][j-1] - prefixSum[i-1][l] + prefixSum[i-1][j-1]));
                    }
                }
            }
        }

        System.out.println(ans);
    }
}