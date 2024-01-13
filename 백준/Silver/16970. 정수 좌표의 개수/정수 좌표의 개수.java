import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int r1 = 0; r1 <= N; r1++) {
            for (int c1 = 0; c1 <= M; c1++) {
                for (int r2 = 0; r2 <= N; r2++) {
                    for (int c2 = 0; c2 <= M; c2++) {
                        if(gcd(Math.abs(r2-r1), Math.abs(c2-c1)) + 1 == K) cnt ++;
                    }
                }
            }
        }
        System.out.println(cnt/2);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}