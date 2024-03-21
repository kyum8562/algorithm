import java.io.*;
import java.util.*;

class Main {
    static int N, ans;
    static int[] arr;
    static List<Integer>[] graph;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        v = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        int curCost = 0;

        for (int i = 1; i <= N; i++) {
            if(v[i]) continue;

            ans = 10001000;
            dfs(i);

            curCost += ans;
        }

        if(K >= curCost)
            System.out.println(curCost);
        else
            System.out.println("Oh no");
    }

        private static void dfs(int cur) {
        v[cur] = true;

        ans = Math.min(ans, arr[cur]);

        for(int next: graph[cur]){
            if(v[next]) continue;

            dfs(next);
        }
    }
}