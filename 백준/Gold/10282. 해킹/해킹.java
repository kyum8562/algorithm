import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<int[]>[] list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list = new ArrayList[N+1];
            for(int i = 1 ; i <= N ; i ++)
                list[i] = new ArrayList<>();

            for(int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                list[b].add(new int[]{a, c});
            }
            dijkstra(C);
        }
        System.out.println(sb);
    }

    private static void dijkstra(int s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        pq.offer(new int[]{s, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(cur[1] > dist[cur[0]]) continue;

            for(int[] next: list[cur[0]]){
                if(dist[next[0]] > dist[cur[0]] + next[1]){
                    dist[next[0]] = dist[cur[0]] + next[1];
                    pq.offer(new int[]{next[0], dist[next[0]]});
                }
            }
        }

        int cnt = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 1 ; i <= N ; i ++){
            if(dist[i] == Integer.MAX_VALUE) continue;
            cnt++;
            max = Math.max(max, dist[i]);
        }
        sb.append(cnt).append(" ").append(max).append("\n");
    }
}