import java.io.*;
import java.util.*;

public class Main {
    static int N, ans, root, max;
    static int[] arr;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ans = 0;

        arr = new int[N+1];
        list = new ArrayList[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < N-1 ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        root = 1;
        max = 0;
        recur(root, 0, arr[root]);

        int tmp = root;
        max = 0;
        recur(root, 0, arr[root]);

        sb.append(max).append(" ").append(Math.min(tmp, root));
        System.out.print(sb);
    }

    private static void recur(int cur, int prev, int dist) {
        if(dist > max){
            max = dist;
            root = cur;
        }
        else if(dist == max)
            root = Math.min(root, cur);

        for(int next: list[cur]){
            if(next == prev) continue;

            recur(next, cur, arr[next]+dist);
        }
    }
}