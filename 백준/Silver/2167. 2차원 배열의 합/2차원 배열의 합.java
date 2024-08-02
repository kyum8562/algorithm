import java.io.*;
import java.util.*;

public class Main {
    static int[][] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        prefixSum = new int[N+1][M+1];

        for(int i = 1 ; i <= N ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= M ; j ++)
                prefixSum[i][j] = prefixSum[i][j-1] + Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i <= N ; i ++){
            for(int j = 1 ; j <= M ; j ++)
                prefixSum[i][j] += prefixSum[i-1][j];
        }

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i ++){
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            sb.append(calculating(r1, c1, r2, c2)).append("\n");
        }

        System.out.print(sb);
    }

    private static int calculating(int r1, int c1, int r2, int c2) {
        return prefixSum[r2][c2] - prefixSum[r2][c1-1] - prefixSum[r1-1][c2] + prefixSum[r1-1][c1-1];
    }
}