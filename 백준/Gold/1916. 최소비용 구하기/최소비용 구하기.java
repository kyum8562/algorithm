import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Node>[] graph;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;
    static class Node {
        int node;
        int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[n1].add(new Node(n2, d));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end));
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        for(int i = 1 ; i <= N ; i++) dist[i] = INF;

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node currNode = pq.poll();
            int curr = currNode.node;

            if(currNode.dist > dist[curr]) continue;

            for(Node next: graph[curr]){
                if(dist[next.node] > dist[curr] + next.dist){
                    dist[next.node] = dist[curr] + next.dist;
                    pq.offer(new Node(next.node, dist[next.node]));
                }
            }
        }

        return dist[end];
    }
}