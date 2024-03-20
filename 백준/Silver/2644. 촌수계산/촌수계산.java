import java.io.*;
import java.util.*;
class Main {
    static int N, E, ans;
    static List<Integer>[] list;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        ans = -1;

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        v = new boolean[N+1];
        list = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i ++)
            list[i] = new ArrayList<>();

        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(S, 0);

        System.out.println(ans);
    }

    private static void dfs(int cur, int cnt) {
        v[cur] = true;

        if(cur == E){
            ans = cnt;
            return;
        }

        for(int next: list[cur]){
            if(v[next]) continue;

            dfs(next, cnt + 1);
        }
    }
}