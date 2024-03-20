import java.io.*;
import java.util.*;

class Main {
    static int cnt;
    static boolean[] v;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i ++)
            list[i] = new ArrayList<>();

        v = new boolean[N+1];

        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        System.out.print(cnt-1);
    }

    private static void dfs(int cur) {
        v[cur] = true;
        cnt ++;

        for(int next: list[cur]){
            if(v[next]) continue;

            dfs(next);
        }
    }
}