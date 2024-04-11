import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        makeSet();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 합집합
            if (a == 0) {
                union(b, c);
            }
            // 두 원소가 같은 집합에 포함되어 있는지 확인
            else
                sb.append((isSameParent(b, c) ? "YES" : "NO")  + "\n");
        }
        System.out.println(sb);
    }

    private static int find(int x) {
        if (x == arr[x]) return x;
        else return arr[x] = find(arr[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) arr[y] = x;
            else arr[x] = y;
        }
    }

    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) return false;
        else return true;
    }


    private static void makeSet() {
        for (int i = 1; i <= N; i++)
            arr[i] = i;
    }


}