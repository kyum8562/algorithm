import java.io.*;
import java.util.*;

public class Main {
    static int[] parents;
    static List<Node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        parents = new int[N+1];

        for(int i = 1 ; i <= N ; i ++)
            parents[i] = i;

        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.add(new Node(a, b, d));
        }

        Collections.sort(list);

        // 크루스칼
        int ans = 0;
        for(Node cur: list){
            if(find(cur.a) == find(cur.b)) continue;
            union(cur.a, cur.b);
            ans += cur.d;
        }

        System.out.print(ans);
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

    static class Node implements Comparable<Node>{
        int a, b, d;
        public Node(int a, int b, int d){
            this.a = a;
            this.b = b;
            this.d = d;
        }

        @Override
        public int compareTo(Node o){
            return this.d - o.d;
        }
    }
}