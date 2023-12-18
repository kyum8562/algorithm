import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        int[] W = new int[N+1];
        int[] V = new int[N+1];
        int[] DP = new int[101];

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i ++){
            W[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i ++){
            V[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i <= N ; i ++){
            for(int j = 100 ; j > W[i] ; j --){
                DP[j] = Math.max(DP[j], DP[j-W[i]] + V[i]);
            }
        }
        System.out.println(DP[100]);
    }
}