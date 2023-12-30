import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X;
    static int INF = Integer.MAX_VALUE;
    static List<Node>[] graph, reverseGraph;
    static boolean[] v;
    static int[] dist, reverseDist;

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
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];

        dist = new int[N + 1];
        reverseDist = new int[N + 1];
        Arrays.fill(dist, INF);
        Arrays.fill(reverseDist, INF);


        for(int i = 1 ; i <= N ; i ++){
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[v1].add(new Node(v2, d));
            reverseGraph[v2].add(new Node(v1, d));
        }

        dijkstra(graph, dist, X);
        dijkstra(reverseGraph, reverseDist, X);

        System.out.println(cal());
    }

    private static int cal() {
        int ans = Integer.MIN_VALUE;
        for(int i = 1 ; i <= N ; i ++){
            ans = Math.max(ans, dist[i] + reverseDist[i]);
        }
        return ans;
    }

    private static void dijkstra(List<Node>[] graph, int[] dist, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        v = new boolean[N + 1];

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            int curr = pq.poll().node;

            if(v[curr]) continue;
            v[curr] = true;

            for(Node next: graph[curr]){
                if(dist[next.node] > dist[curr] + next.dist){
                    dist[next.node] = dist[curr] + next.dist;
                    pq.offer(new Node(next.node, dist[next.node]));
                }
            }
        }
    }
}