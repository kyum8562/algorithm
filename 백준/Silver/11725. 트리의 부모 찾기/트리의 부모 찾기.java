import java.io.*;
import java.util.*;

public class Main {
    static int[] parents;
    static boolean[] v;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        parents = new int[N+1];
        v = new boolean[N+1];
        list = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i ++)
            list[i] = new ArrayList<>();

        for(int i = 0 ; i < N-1 ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for(int i = 2 ; i <= N ; i ++)
            sb.append(parents[i]).append("\n");

        System.out.println(sb);
    }

    private static void dfs(int cur) {
        v[cur] = true;

        for(int next: list[cur]){
            if(v[next]) continue;
            parents[next] = cur;
            dfs(next);
        }
    }
}