import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] prefixSum = new int[N+1]; // 패딩
        int[] map = new int[N+1]; // 패딩
        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i-1] + map[i];
        }
        long sum = 0;
        for (int i = 1; i < N ; i++) {
            sum += (prefixSum[N] - prefixSum[i])*map[i];
        }
        System.out.println(sum);
    }
}