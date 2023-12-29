import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] prefixSum = new int[N+1][M+1]; // 패딩
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                prefixSum[i][j] = prefixSum[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }
        int tc = Integer.parseInt(br.readLine());
        while(tc -- > 0){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int sum = 0;
            for(int a = i ; a <= x ; a ++)
                sum += prefixSum[a][y] - prefixSum[a][j-1];
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}