import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        dp = new int[2000][2000];

        for(int i = 0 ; i < N ; i ++)
            arr[i] = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < 2000 ; i ++)
            Arrays.fill(dp[i], -1);

        System.out.println(recur(0, 0)); // 인덱스, 현재 사용한 칸의 수
    }

    private static int recur(int idx, int usedCnt) {
        if(idx == N) return 0;
        if(dp[idx][usedCnt] != -1) return dp[idx][usedCnt];

        int spare = M - usedCnt + 1;

        // 강제로 다음줄로 넘길 때
        int ret = recur(idx + 1, arr[idx] + 1) + (int) Math.pow(spare, 2);

        // 이어서 작성할 때, 안 넘치는경우
        if(M >= usedCnt + arr[idx])
            ret = Math.min(recur(idx + 1, usedCnt + arr[idx] + 1), ret);

        return dp[idx][usedCnt] = ret;
    }
}
