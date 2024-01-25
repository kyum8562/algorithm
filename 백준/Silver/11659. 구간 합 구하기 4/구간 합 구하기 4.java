import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
//    static final int INF = Integer.MIN_VALUE;
    static int[] prefixSum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        prefixSum = new int[N+1];

        // 누적합 구하기
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N; i ++){
            int tmp = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i-1] + tmp;
        }

        while(M -- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(prefixSum[b] - prefixSum[a-1]).append("\n");
        }
        System.out.println(sb);
    }
}