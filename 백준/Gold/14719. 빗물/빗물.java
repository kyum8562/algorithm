import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
//    static final int INF = Integer.MIN_VALUE;
    static int[] prefixSum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] map = new int[M];

        int maxLenIdx = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i ++){
            map[i] = Integer.parseInt(st.nextToken());
            if(map[i] > map[maxLenIdx]) maxLenIdx = i;
        }


        int i = 0;
        int ans = 0;
        for(int j = 0 ; j <= maxLenIdx ; j ++){
            if(map[j] >= map[i]){
                int k = j;
                while(-- k > i){
                    ans += map[i] - map[k];
                }
                i = j;
            }
        }

        i = M-1;
        for(int j = M-1 ; j >= maxLenIdx ; j --){
            if(map[j] >= map[i]){
                int k = j;
                while(++ k < i){
                    ans += map[i] - map[k];
                }
                i = j;
            }
        }

        System.out.println(ans);
    }
}