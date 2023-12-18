import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int ans, N, K;
    static int[][] items;
    static int[][] dp;
//    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 물건 수
        K = Integer.parseInt(st.nextToken()); // 가방 최대 무게

        items = new int[N+1][2];
        dp = new int[N+1][K+1];
//        dp = new int[K+1];


        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

//        playDP1();
        playDP2();
//        play(K, 0);

//        System.out.println(dp[K]);
        System.out.println(dp[N][K]);
    }

    private static void playDP2() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                // 해당 위치에 물건을 넣을 수 없는 경우.
                if (items[i][0] > j) {
                    // i - 1번째 물건까지 고려했을때 무게 j에서의 최대 가치(최적해)를 그대로 가져온다.
                    dp[i][j] = dp[i - 1][j];
                }
                // 해당 위치에 물건을 넣을 수 있는 경우.
                else {
                    // i - 1번째 물건까지 고려했을때 무게 j에서의 최대 가치(최적해)와,
                    // i - 1번째 물건까지 고려했을때 무게 j - items[i][0](현재 무게)의 최대 가치(최적해) + items[i][1](현재 가치) 중에서
                    // 더 큰 값을 선택한다!
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i][0]] + items[i][1]);
                }
            }
        }
    }

    // DP - 1차원배열
//    private static void playDP1() {
//        for (int i = 1; i <= N; i++) {
//            for (int j = K; j >= items[i][0]; j--) {
//                dp[j] = Math.max(dp[j], dp[j - items[i][0]] + items[i][1]);
//            }
//        }
//    }

    // 백트래킹
    private static void play(int K, int good) {
        // 기저조건
        if(K <= 0){
            if(K==0 && good > ans) ans = good;
            return;
        }

        //
        for(int i = 1 ; i <= N ; i ++){
            play(K-items[i][0], good+items[i][1]);
        }
    }
}