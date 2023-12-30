import java.io.*;
import java.util.*;

// 1번 정점에서 N번 정점으로 이동할 때, 주어진 두 정점을 반드시 거치면서 최단 경로
public class Main {
    static int N, E, ans;
    static int[] dist;
    static List<Node>[] graph;
    static int INF = Integer.MAX_VALUE;

    static class Node {
        int dist;
        int n;

        public Node(int n, int dist) {
            this.n = n;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        ans = INF;

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
//            dist[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 시작 정점
            int v = Integer.parseInt(st.nextToken()); // 종료 정점
            int w = Integer.parseInt(st.nextToken()); // 가중치

            // 양방향
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken()); // 임의의 정점1
        int v2 = Integer.parseInt(st.nextToken()); // 임의의 정점2

        long tmp = 0;
        tmp += dijkstra(1, v1);
        tmp += dijkstra(v1, v2);
        tmp += dijkstra(v2, N);

        ans = (int) Math.min(ans, tmp);

        tmp = 0;

        tmp += dijkstra(1, v2);
        tmp += dijkstra(v2, v1);
        tmp += dijkstra(v1, N);

        ans = (int) Math.min(ans, tmp);

        System.out.println(ans != INF? ans : -1);
    }

    private static int dijkstra(int start, int end) {
        // 우선순위 큐 - 가중치를 기준으로 오름차순
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);

        for (int j = 1; j <= N; j++) dist[j] = INF;

        q.offer(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            // 현재 최단거리가 가장 짧은 노드 꺼내서 방문처리
            Node currNode = q.poll();
            int curr = currNode.n;
            
            if(currNode.dist > dist[curr]) continue;

            for (Node next : graph[curr]) {
                // 방문하지 않았고, 현재 노드를 거쳐 다른 노드로 이동하는 거리가 더 짧을 경우
                if (dist[next.n] > dist[curr] + next.dist) {
                    dist[next.n] = dist[curr] + next.dist;
                    q.offer(new Node(next.n, dist[next.n]));
                }
            }
        }
        return dist[end];
    }

}