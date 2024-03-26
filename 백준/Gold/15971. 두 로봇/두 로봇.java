import java.io.*;
import java.util.*;

class Main {
    static List<Node>[] list;
    static int N, S, E;
    static boolean[] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        v = new boolean[N+1];
        list = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i ++)
            list[i] = new ArrayList<>();

        for(int i = 0 ; i < N-1 ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, d));
            list[b].add(new Node(a, d));
        }

        v[S] = true;
        dfs(S, 0, 0);
    }

    private static void dfs(int cur, int d, int max) {
        if(cur == E){
            System.out.println(d- max);
            return;
        }

        for(Node next: list[cur]){
            if(v[next.n]) continue;
            v[next.n] = true;

            dfs(next.n, d + next.d, Math.max(max, next.d));
        }
    }

    static class Node {
        int n, d;

        public Node(int n, int d) {
            this.n = n;
            this.d = d;
        }
    }
}