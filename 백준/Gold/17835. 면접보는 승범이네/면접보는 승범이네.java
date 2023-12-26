import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int INF = Integer.MAX_VALUE;
    static long[] dist, res;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (int) (o1.d - o2.d));
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        res = new long[N+1];
        dist = new long[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Long.MAX_VALUE;
            res[i] = Long.MAX_VALUE;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[b].add(new Node(a, d)); // 단방향(입력받은 간선 반대로 저장)
        }

        // k개의 면접장을 기준으로 다익스트라
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int val = Integer.parseInt(st.nextToken()); // 시작점(면접장)을 모두 pq에 넣어줌
            dist[val] = 0;
            pq.offer(new Node(val, 0));
        }
        dijkstra();

        long ans = -1;
        int idx = 0;
        for(int i = 1 ; i <= N ; i ++){
            if(dist[i] > ans){
                ans = dist[i];
                idx = i;
            }
        }
        System.out.println(idx);
        System.out.println(ans);
    }

    private static void dijkstra() {

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if(curr.d > dist[curr.n]) continue;

            for(Node next: graph[curr.n]){
                if(dist[next.n] > dist[curr.n] + next.d){
                    dist[next.n] = dist[curr.n] + next.d;
                    pq.offer(new Node(next.n, dist[next.n]));
                }
            }
        }
    }
    static class Node {
        int n;
        long d;

        public Node(int n, long d) {
            this.n = n;
            this.d = d;
        }
    }
}