import java.io.*;
import java.util.*;
public class Main {
    static long[] t = new long[100000]; // 소인수
    static long[] s = new long[100000]; // t[i]에 해당하는 소인수의 개수
    static long[] p = new long[100000]; // N!을 소인수 t[i]로 나눌 수 있는 최대 개수
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

            K_Factorization(K); // k 소인수 분해
            N_Factorization(N); // n!을 소인수 분해하여 계수를 구함
            result(); // 최소 계수를 찾아 출력

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

    private static void N_Factorization(long N) {
        for (int i = 0; i < index; i++) {
            long j = 1;
            long tempN = N;
            while (tempN / t[i] > 0) {
                p[i] += tempN / t[i];
                tempN /= t[i];
            }
        }
    }

    private static void K_Factorization(long k) {
        // 2 ~ sqrt(k) 까지 소인수 분해 수행 -> 시간초과 해결
        for (long i = 2; i * i <= k; i++) {
            // i로 소인수 분해 불가 => pass
            if (k % i != 0) continue;

            // i로 소인수 분해
            int count = 0; // i로 분해되는 개수
            while (k % i == 0) {
                count++;
                k /= i;
            }
            if(count > 0){
                // 인덱스가 0이거나 마지막에 저장한 소인수가 현재 소인수와 다르다면 -> 새로운 소인수로 인식하고 저장
                if (index == 0 || t[index - 1] != i) {
                    t[index] = i;
                    s[index] = count;
                    index++;
                }
                // 이외는, 이전에 저장한 소인수와 동일함 -> 개수 증가
                else s[index - 1] += count;
            }
        }
        // 남은 소인수 처리
        if (k > 1) {
            s[index]++;
            t[index++] = k;
        }
    }
}