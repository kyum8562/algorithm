import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] prefixSum = new int[N+1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i-1] + Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;
        int idx = N;
        while(idx-K >= 0){
            max = Math.max(max, prefixSum[idx] - prefixSum[idx-K]);
            idx--;
        }
        System.out.println(max);
    }
}