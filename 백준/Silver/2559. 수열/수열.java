import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] prefixSum = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i ++){
            int tmp = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i-1] + tmp;
        }

        int idx = N;
        int max = Integer.MIN_VALUE;
        while(true){
            int tmp = idx - K;
            if(tmp < 0) break;
            max = Math.max(max, prefixSum[idx] - prefixSum[tmp]);
            idx --;
        }

        System.out.println(max);
    }
}