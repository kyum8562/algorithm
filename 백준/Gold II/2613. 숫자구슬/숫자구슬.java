import java.io.*;
import java.util.*;

public class Main {
    static int[] beads;
    static int N, M;
    static int s = 0, e = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        beads = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            beads[i] = Integer.parseInt(st.nextToken());
            s = Math.max(s, beads[i]);
            e += beads[i];
        }

        binarySearch();
        System.out.println(s);

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += beads[i];
            if (sum > s) {
                M--;
                sum = beads[i];
                sb.append(cnt).append(" ");
                cnt = 1;
            } else {
                cnt++;
            }

            if(M == N - i) break;
        }

        while(M-- > 0) {
            sb.append(cnt).append(" ");
            cnt = 1;
        }

        System.out.println(sb);
    }

    static void binarySearch() {
        int m = 0;
        while (e >= s) {
            m = (e + s) / 2;

            int cnt = getCnt(m);

            if (cnt > M) s = m + 1;
            else e = m - 1;
        }
    }

    static int getCnt(int m) {
        int sum = 0;
        int cnt = 1;

        for (int i = 0; i < N; i++) {
            sum += beads[i];
            if (sum > m) {
                cnt++;
                sum = beads[i];
            }
        }

        return cnt;
    }
}