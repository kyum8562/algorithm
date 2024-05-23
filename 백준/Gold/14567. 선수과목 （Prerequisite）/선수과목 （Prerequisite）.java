import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] in, ans;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        in = new int[N+1]; // 진입 차수
        ans = new int[N+1]; // 몇학기만에 이수했는지 저장

        for(int i = 1 ; i <= N ; i ++)
            list[i] = new ArrayList<>();

        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            in[b] ++;
        }

        bfs();

        for(int i = 1 ; i <= N ; i ++)
            sb.append(ans[i]).append(" ");

        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 1 ; i <= N ; i ++)
            if(in[i] == 0) q.offer(i);

        int time = 1;

        while(!q.isEmpty()){
            int qSize = q.size();

            for(int i = 0 ; i < qSize ; i ++){
                int cur = q.poll();

                ans[cur] = time;

                for(int next: list[cur]){
                    if(--in[next] == 0) q.offer(next);
                }
            }

            time ++;
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