import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] W = new int[N+1];
        int[] V = new int[N+1];
        int[] DP = new int[K+1];

        for(int i = 1 ; i <= N ; i ++){
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i <= N ; i ++){
            for(int j = K ; j >= W[i] ; j --){
                DP[j] = Math.max(DP[j], DP[j-W[i]] + V[i]);
            }
        }
        System.out.println(DP[K]);
    }
}