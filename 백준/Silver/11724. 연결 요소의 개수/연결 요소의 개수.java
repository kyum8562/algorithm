import java.io.*;
import java.util.*;

class Main {
    static boolean[] v;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i ++)
            list[i] = new ArrayList<>();

        v = new boolean[N+1];

        int ans = 0; // 연결 요소의 개수

        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 1 ; i <= N ; i ++){
            if(v[i]) continue;

            ans ++;

            dfs(i);
        }

        System.out.print(ans);
    }

    private static void dfs(int cur) {
        v[cur] = true;

        for(int next: list[cur]){
            if(v[next]) continue;

            dfs(next);
        }
    }
    static class Node{
        int r, c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}