import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] v;
    static int cnt, M;
    static boolean isCheck;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        v = new boolean[N];

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        dfs(0);

        System.out.println(!isCheck ? cnt : -1);
    }

    private static void dfs(int cur) {
        if (v[cur])
            isCheck = true;

        else {
            v[cur] = true;

            if(cur == M) return;

            dfs(arr[cur]);
            cnt ++;
        }
    }
}