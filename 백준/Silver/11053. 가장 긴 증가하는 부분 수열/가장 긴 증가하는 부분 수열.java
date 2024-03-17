import java.io.*;
import java.util.*;

public class Main {
    static int ans, N;
    static int[] boxes, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        boxes = new int[N+1];
        dp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            boxes[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        play();
        System.out.println(ans);
    }

    private static void play() {
        for(int i = 1 ; i <= N ; i ++){
            for(int j = 1 ; j < i ; j ++){

                // 현재 값이 이전값보다 클 경우, dp[i] 갱신
                if(boxes[i] > boxes[j]){
                    // LTS 중 가장 큰 값 + 1 로 갱신
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }

            ans = Math.max(dp[i], ans);
        }
    }
}