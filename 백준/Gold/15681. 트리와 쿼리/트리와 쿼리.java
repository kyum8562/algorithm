import java.io.*;
import java.util.*;

public class Main {
    static int[] size;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        size = new int[N+1];
        list = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i ++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < N-1 ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(R, 0);

        for(int i = 0 ; i < Q ; i ++)
            sb.append(size[Integer.parseInt(br.readLine())]).append("\n");

        System.out.print(sb);
    }

    private static void dfs(int cur, int prev) {
        size[cur] = 1;

        for(int next: list[cur]){
            if(next == prev) continue;

            dfs(next, cur);

            size[cur] += size[next];
        }
    }
}