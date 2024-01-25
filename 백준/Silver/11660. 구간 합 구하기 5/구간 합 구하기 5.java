import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
//    static final int INF = Integer.MIN_VALUE;
    static int[][] prefixSum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        prefixSum = new int[N+1][N+1];

        // 누적합 구하기
        for(int i = 1 ; i <= N; i ++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j ++) {
                int tmp = Integer.parseInt(st.nextToken());
                prefixSum[i][j] = prefixSum[i][j-1] + tmp;
            }
        }

        while(M -- > 0){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            long sum = 0;
            for(int i = x1 ; i <= x2 ; i ++){
                sum += prefixSum[i][y2] - prefixSum[i][y1-1];
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}