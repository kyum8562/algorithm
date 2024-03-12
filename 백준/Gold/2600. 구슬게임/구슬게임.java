import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] B = new int[3];
        for (int i = 0; i < 3; i++)
            B[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[501];
        dp[0] = 0;

        boolean[] check = new boolean[4];
        for (int i = 1; i <= 500; i++) {
            Arrays.fill(check, false);

            for (int j = 0; j < 3; j++) {
                if (i - B[j] >= 0) {
                    check[dp[i - B[j]]] = true;
                }
            }

            int max = 0;
            while (check[max]) {
                max++;
            }
            dp[i] = max;
        }

        int T = 5;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int k1 = Integer.parseInt(st.nextToken());
            int k2 = Integer.parseInt(st.nextToken());

            sb.append((dp[k1] ^ dp[k2]) == 0 ? "B\n" : "A\n");
        }
        System.out.println(sb);
    }
}