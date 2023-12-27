import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arrR = new int[N];
        int[] arrC = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arrR[i] = Integer.parseInt(st.nextToken());
            arrC[i] = Integer.parseInt(st.nextToken());
        }

        long[] ans = new long[N];
        Arrays.fill(ans, Long.MAX_VALUE);
        for (int i = 0; i < N; i++) { // // targetR
            for (int j = 0; j < N; j++) { // targetC // 2500
                int targetR = arrR[i];
                int targetC = arrC[j];
                int[] localDist = new int[N];
                // 현 지점에서, N개의 거리를 구함
                for (int k = 0; k < N; k++) { // k번째 답 찾기 // 125000
                    localDist[k] = Math.abs(targetR - arrR[k]) + Math.abs(targetC - arrC[k]);
                }
                // 정렬
                Arrays.sort(localDist); // 50log50
                for (int k = 0; k < N; k++) {
                    long sum = 0;
                    for (int l = 0; l <= k; l++)
                        sum += localDist[l];
                    ans[k] = Math.min(ans[k], sum);
                }
            }
        }
        for (int i = 0; i < N; i++)
            sb.append(ans[i]).append(" ");
        System.out.println(sb);
    }
}