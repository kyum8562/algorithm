import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int d;
        int n;
        public Node(int n, int d){
            this.n = n;
            this.d = d;
        }
    }
    static int V, E, startV;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;
    static List<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];
        dist = new int[V+1];

        for(int i = 1 ; i <= V ; i ++){
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        st = new StringTokenizer(br.readLine());
        startV = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < E ; i ++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 시작 정점
            int v = Integer.parseInt(st.nextToken()); // 종료 정점
            int w = Integer.parseInt(st.nextToken()); // 가중치

            graph[u].add(new Node(v, w));
        }

        dijkstra(startV);

        for(int i = 1 ; i <= V ; i ++){
            if(dist[i] != INF) System.out.println(dist[i]);
            else System.out.println("INF");
        }
    }

    private static void dijkstra(int startV) {
        // 우선순위 큐 - 가중치를 기준으로 오름차순
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);

        q.offer(new Node(startV, 0));
        dist[startV] = 0;

        while(!q.isEmpty()){
            // 현재 최단거리가 가장 짧은 노드 꺼내서 방문처리
            Node curr = q.poll();
            if(curr.d > dist[curr.n]) continue;

            for(Node next: graph[curr.n]){
                // 방문하지 않았고, 현재 노드를 거쳐 다른 노드로 이동하는 거리가 더 짧을 경우
                if(dist[next.n] > curr.d + next.d){
                    dist[next.n] = curr.d + next.d;
                    q.offer(new Node(next.n, dist[next.n]));
                }
            }
        }
   }
}