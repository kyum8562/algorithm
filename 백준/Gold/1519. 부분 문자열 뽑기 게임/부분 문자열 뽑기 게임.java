import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        if (N < 10) sb.append("-1");
        else {
            int[] dp = new int[N + 1];

            for (int n = 10; n <= N; n++) {
                String str = String.valueOf(n);
                Set<String> set = new HashSet<>();

                for (int start = 0; start < str.length(); start++) {
                    if (str.charAt(start) == '0') {
                        continue;
                    }

                    String res = "";
                    for (int i = start; i < str.length(); i++) {
                        res += str.charAt(i);

                        if (!res.equals(str)) {
                            set.add(res);
                        }
                    }
                }

                Iterator<String> it = set.iterator();

                int min = Integer.MAX_VALUE;
                while (it.hasNext()) {
                    int num = Integer.parseInt(str);
                    int temp = Integer.parseInt(it.next());

                    if (dp[num - temp] == 0) {
                        min = Math.min(min, temp);
                    }
                }

                if (min != Integer.MAX_VALUE)
                    dp[n] = min;
            }

            sb.append(dp[N] == 0 ? "-1" : dp[N]).append("\n");
        }
        System.out.print(sb);
    }

}