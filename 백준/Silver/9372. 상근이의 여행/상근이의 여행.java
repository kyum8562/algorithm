import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans;
    static boolean[] v;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T ; t ++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            list = new ArrayList[N + 1];
            v = new boolean[N + 1];

            for (int i = 1; i <= N; i++)
                list[i] = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }

            ans = 0;

            for(int i = 1 ; i <= N ; i ++){
                if(v[i]) continue;
                v[i] = true;

                dfs(i);
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }

    private static void dfs(int cur) {
        for(int next: list[cur]){
            if(v[next]) continue;
            v[next] = true;
            ans ++;

            dfs(next);
        }
    }
}
