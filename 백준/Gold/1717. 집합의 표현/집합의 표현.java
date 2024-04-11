import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parents = new int[N+1];

        // parents 배열 초기화
        makeSet();

        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // union
            if(type == 0) union(a, b);
            // print
            else sb.append(isSameParent(a, b) ? "YES" : "NO").append("\n");
        }


        System.out.print(sb);
    }

    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return true;
        return false;
    }

    private static void makeSet() {
        for(int i = 1 ; i <= N ; i ++)
            parents[i] = i;
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) parents[y] = x;
    }

    private static int find(int x) {
        if(x == parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }
}