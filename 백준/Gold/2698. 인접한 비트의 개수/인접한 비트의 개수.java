import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // dp[비트 길이][인접한 비트 개수][맨 끝 수가 0인지 1인지] = 인접한 비트 개수를 가진 수열의 개수
        int[][][] dp = new int[101][101][2];

        // 기저
        dp[1][0][1] = 1;
        dp[1][0][0] = 1;

        for(int i = 0 ; i < 101 ; i ++){
            for(int j = 2 ; j < 101 ; j ++){
                if(i == 0) dp[j][i][1] = dp[j-1][i][0];
                else dp[j][i][1] = dp[j-1][i-1][1] + dp[j-1][i][0];

                dp[j][i][0] = dp[j-1][i][1] + dp[j-1][i][0];
            }
        }

        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T ; t ++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            sb.append(dp[N][K][0] + dp[N][K][1]).append("\n");
        }

        System.out.println(sb);
    }
}