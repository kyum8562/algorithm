import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+10];

        // 기저
        dp[1] = 1;
        dp[2] = 2;

        /**
         * (기저를 생각하지 말고) 첫 시작에서 경우의 수를 생각해보면
         * case 1) 세로로 1개 놓았을 때 -> N-1개를 자유롭게 놓아도 된다.
         * case 2) 가로로 2개 놓았을 때 -> N-2개를 자유롭게 놓아도 된다.
         *
         * 그렇다면, i번째에서의 경우의 수는
         * i-1개를 자유롭게 놓는 경우의 수 + i-2개를 자유롭게 놓는 경우의 수임
         *
         * dp[입력] = 출력이라고 생각했을 때
         * 이 문제의 dp[i]에서 i는 가로길이를 의미하며 dp[i]는 가로길이에 따른 경우의 수임
         *
         * 결론
         * dp[i] = dp[i-1] + dp[i-2]
         */
        for(int i = 3 ; i <= N ; i ++)
            dp[i] = (dp[i-1] + dp[i-2]) % 10_007;

        System.out.println(dp[N]);
    }
}