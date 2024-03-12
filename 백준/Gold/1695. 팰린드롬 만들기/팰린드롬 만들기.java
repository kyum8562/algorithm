import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] num;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i ++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N][N];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        int S = 0;
        int E = N - 1;
        System.out.println(palindrome(S, E));
    }

    static int palindrome(int S, int E) {
        if (S > E) {
            return 0;
        }

        // 가지치기
        if (dp[S][E] != -1) {
            return dp[S][E];
        }

        // 같다면 줄이기
        if (num[S] == num[E]) {
            dp[S][E] = palindrome(S+1, E-1);
        }
        // 다르다면 숫자를 끼워야됨
        // 더 최소인것을 고른다(끝추가, 앞추가)
        else {
            dp[S][E] = Math.min(palindrome(S+1, E) + 1, palindrome(S, E-1) + 1);
        }

        return dp[S][E];
    }
}