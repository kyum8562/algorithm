import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Node>[] graph;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int node;
        int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        dist = new int[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 1; i <= N; i++) dist[i] = INF;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, d));
            graph[e].add(new Node(s, d));
        }


        dijkstra(1);
        System.out.println(dist[N]);

    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node currNode = pq.poll();
            int curr = currNode.node;

            for(Node next: graph[curr]){
                if(dist[next.node] > dist[curr] + next.dist){
                    dist[next.node] = dist[curr] + next.dist;
                    pq.offer(next);
                }
            }

        }
    }
}