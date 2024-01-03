import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static List<Node>[] graph;
    static int[] dist;
    static class Node{
        int node;
        int dist;
        public Node(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i ++) graph[i] = new ArrayList<>();

        for(int i = 1 ; i <= M ; i ++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, d));
            graph[e].add(new Node(s, d));
        }

        int len1 = dijkstra(1, N);
        int len2 = dijkstra(1, K) + dijkstra(K, N);

        System.out.println(len1 == len2 ? "SAVE HIM" : "GOOD BYE");

    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        pq.offer(new Node(start, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
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