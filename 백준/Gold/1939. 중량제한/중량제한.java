import java.io.*;
import java.util.*;

public class Main {
    static int ans;
    static boolean[] v;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i ++)
            list[i] = new ArrayList<>();

        int l = 0, r = 0, m;
        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, d));
            list[b].add(new Node(a, d));

            r = Math.max(r, d);
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        while(r >= l){
            m = (l + r) / 2;

            ans = -1;
            v = new boolean[N+1];

            dfs(S, E, m);

            if(ans == -1) r = m - 1;
            else l = m + 1;
        }

        System.out.println(r);
    }

    private static void dfs(int cur, int end, int m) {
        if(cur == end){
            ans = cur;
            return;
        }

        v[cur] = true;

        for(Node next: list[cur]){
            if(v[next.n] || m > next.d) continue;

            dfs(next.n, end, m);
        }
    }

    static class Node{
        int n;
        long d;

        public Node(int n, long d){
            this.n = n;
            this.d = d;
        }
    }
}