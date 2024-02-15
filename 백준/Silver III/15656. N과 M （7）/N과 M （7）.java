import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] target;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        target = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        comb(0);
        System.out.print(sb);
    }

    private static void comb(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++)
                sb.append(target[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            target[cnt] = arr[i];
            comb(cnt + 1);
        }
    }
}