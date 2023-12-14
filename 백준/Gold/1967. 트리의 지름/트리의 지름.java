import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    static boolean[] v;
    static List<Node>[] list;

    static class Node {
        int n, d;
        public Node(int n, int d) {
            this.n = n;
            this.d = d;
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        int[] tmp = new int[N + 1];
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));

        }

        for (int i = 1; i <= N; i++) {
            v = new boolean[N + 1];
            v[i] = true;
            dfs(i, 0);
        }

        System.out.println(ans);
    }

    private static void dfs(int i, int sum) {
        for (Node next : list[i]) {
            if(v[next.n]) continue;
            v[next.n] = true;
            dfs(next.n, sum+next.d);
        }
        ans = Math.max(ans, sum);
    }
}