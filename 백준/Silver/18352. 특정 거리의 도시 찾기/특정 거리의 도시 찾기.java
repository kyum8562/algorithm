import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static List<Integer>[] list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i ++)
            list[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
        }
        dijkstra(X);
        System.out.println(sb.length() == 0 ? -1 : sb);
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

            for(Integer next: list[cur[0]]){
                if(dist[next] > dist[cur[0]] + 1){
                    dist[next] = dist[cur[0]] + 1;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        for(int i = 1 ; i <= N ; i ++)
            if(dist[i] == K) sb.append(i).append("\n");
    }
}