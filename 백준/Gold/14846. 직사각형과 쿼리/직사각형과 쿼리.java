import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][][] prefixSum = new int[N+1][N+1][11];

        // 행 기준 누적합
        for(int i = 1 ; i <= N ; i ++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N ; j++){
                int cur = Integer.parseInt(st.nextToken());
                prefixSum[i][j][cur] ++;

                // 이전 값들 끌어오기
                for(int k = 1 ; k <= 10 ; k ++)
                    prefixSum[i][j][k] += prefixSum[i][j-1][k];
            }
        }

        // 열 기준 누적합
        for(int i = 1 ; i <= N ; i ++){
            for (int j = 1; j <= N ; j++){
                // 이전 값들 끌어오기
                for(int k = 1 ; k <= 10 ; k ++)
                    prefixSum[i][j][k] += prefixSum[i-1][j][k];
            }
        }

        int Q = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < Q ; i ++){
            int ans = 0;

            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = 1 ; j <= 10 ; j ++){
                int res = prefixSum[x2][y2][j] - prefixSum[x1-1][y2][j] - prefixSum[x2][y1-1][j] + prefixSum[x1-1][y1-1][j];
                if(res >= 1) ans ++;
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}