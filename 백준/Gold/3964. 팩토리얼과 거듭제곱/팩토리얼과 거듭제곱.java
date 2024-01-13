import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] t = new long[100000];
    static long[] s = new long[100000];
    static long[] p = new long[100000];
    static int index;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long K = Long.parseLong(st.nextToken());

            insu(K);
            insu_check(N);
            result();

            // 초기화를 다시 수행하도록 변경
            for (int i = 0; i < index; i++) {
                p[i] = 0;
                s[i] = 0;
                t[i] = 0;
            }
            index = 0;
        }
        System.out.print(sb);
    }

    private static void result() {
        long min = Long.MAX_VALUE;
        for (int i = 0; i < index; i++) {
            long val = p[i] / s[i];
            if (min > val) {
                min = val;
            }
        }
        sb.append(min).append("\n");
    }

    private static void insu_check(long N) {
        for (int i = 0; i < index; i++) {
            long j = 1;
            long tempN = N;
            while (tempN / t[i] > 0) {
                p[i] += tempN / t[i];
                tempN /= t[i];
            }
        }
    }

    private static void insu(long k) {
        for (long i = 2; i * i <= k; i++) {
            if (k % i != 0) {
                continue;
            }
            int count = 0;
            while (k % i == 0) {
                count++;
                k /= i;
            }
            if (count > 0) {
                if (index == 0 || t[index - 1] != i) {
                    t[index] = i;
                    s[index] = count;
                    index++;
                } else {
                    s[index - 1] += count;
                }
            }
        }
        if (k > 1) {
            s[index]++;
            t[index++] = k;
        }
    }
}