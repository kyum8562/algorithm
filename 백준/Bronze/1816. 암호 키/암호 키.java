import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 1000001;
    static boolean[] isPrime;

    static void eratosthenes() {
        for (int i = 2 ; i * i < MAX; i++) {
            for (int j = i * i; j < MAX; j += i) {
                isPrime[j] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        isPrime = new boolean[MAX];

        eratosthenes();

        for (int n = 0; n < N; n++) {
            long S = Long.parseLong(br.readLine());

            boolean flag = true;

            for (int i = 2; i < MAX; i++) {
                if(isPrime[i]) continue;
                if (S % i == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}