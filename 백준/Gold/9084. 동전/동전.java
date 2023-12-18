import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    static int[] map;
    static boolean[][] v;
    static List<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            N = Integer.parseInt(br.readLine());

            map = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                map[i] = Integer.parseInt(st.nextToken());
            }

            int tgt = Integer.parseInt(br.readLine());
            int[] dp = new int[tgt+1];
            for(int i = 1 ; i <= N ; i ++){
                for(int j = 1 ; j <= tgt ; j ++){
                    if(j > map[i])
                        dp[j] = dp[j] + dp[j-map[i]];
                    else if(j == map[i])
                        dp[j] ++;
                }
            }
            System.out.println(dp[tgt]);
        }
    }
}