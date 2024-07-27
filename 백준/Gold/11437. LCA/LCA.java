import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] parent;
    static int[] depth;
    static boolean[] v;
    static Node[] graph;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        depth = new int[N + 1];
        v = new boolean[N + 1];
        graph = new Node[N + 1];

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start] = new Node(end, graph[start]);
            graph[end] = new Node(start, graph[end]);
        }
        dfs(1, 0);

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(LCA(a, b)).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int cur, int d) {
        v[cur] = true;
        depth[cur] = d;


        for (Node temp = graph[cur]; temp != null; temp = temp.child) {
            if(v[temp.n]) continue;

            parent[temp.n] = cur;
            dfs(temp.n, d + 1);
        }
    }

    static int LCA(int a, int b) {
        while (depth[a] != depth[b]) {
            if (depth[a] > depth[b])
                a = parent[a];
            else
                b = parent[b];
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    static class Node {
        int n;
        Node child;

        public Node(int n, Node child) {
            this.n = n;
            this.child = child;
        }
    }
}