import java.io.*;
import java.util.*;

public class Main {
    static int N, max, idx;
    static Integer[] arr;
    static long[] size;
    static List<Long> ans;
    static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        max = -1;

        size = new long[N+1];
        arr = new Integer[N-1];
        ans = new ArrayList<>();
        list = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i ++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < N-1 ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, d));
            list[b].add(new Node(a, d));
        }

        dfs(1, 0, 0);
        max = -1;
        dfs(idx, 0, 0);

        System.out.println(max);
    }

    private static void dfs(int cur, int prev, int curDist) {

        if(curDist > max){
            max = curDist;
            idx = cur;
        }

        for(Node next: list[cur]){
            if(next.n == prev) continue;
            dfs(next.n, cur, curDist + next.d);
        }
    }
    static class Node{
        int n, d;
        public Node(int n, int d){
            this.n = n;
            this.d = d;
        }
    }
}