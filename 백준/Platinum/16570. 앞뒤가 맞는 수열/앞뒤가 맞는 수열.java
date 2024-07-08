import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] pi, array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        // 테이블 생성
        pi = new int[N];
        array = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = N - 1; i >= 0; i--) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        KMP();

        int length = 0, count = 0;
        for (int i = 0; i < N; i++) {
            if (pi[i] > length) {
                length = pi[i];
                count = 0;
            }
            if (pi[i] == length)
                count++;
        }
        if (length == 0)
            System.out.println("-1");
        else
            System.out.println(length + " " + count);
    }

    public static void KMP() {
        int j = 0;
        for (int i = 1; i < N; i++) {
            while (j > 0 && array[j] != array[i]) {
                j = pi[j - 1];
            }
            if (array[j] == array[i]) {
                pi[i] = ++j;
            }
        }
    }
}