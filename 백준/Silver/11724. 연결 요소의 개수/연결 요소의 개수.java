import java.io.*;
import java.util.*;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int ans = 0;

        parents = new int[N+1];

        for(int i = 1 ; i <= N ; i ++)
            parents[i] = i;

        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(find(a) != find(b)) union(a, b);
        }


        Map<Integer, Boolean> map = new LinkedHashMap<>();
        for(int i = 1 ; i <= N ; i ++){
            int cur = find(parents[i]);
            if(map.getOrDefault(cur, false)) continue;

            map.put(cur, true);
            ans ++;
        }

        System.out.print(ans);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x > y) parents[x] = y;
        else parents[y] = x;
    }

    private static int find(int x) {
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }
}