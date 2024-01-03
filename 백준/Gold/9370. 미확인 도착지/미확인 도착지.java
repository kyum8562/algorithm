import java.io.*;
import java.util.*;

public class Main {
    static int N, M, T, S, G, H;
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc -- > 0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 교차로 개수
            M = Integer.parseInt(st.nextToken()); // 도로 개수
            T = Integer.parseInt(st.nextToken()); // 목적지 후보 개수

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken()); // 출발지
            G = Integer.parseInt(st.nextToken()); // 교차로 점1
            H = Integer.parseInt(st.nextToken()); // 교차로 점2

            graph = new ArrayList[N+1];
            for (int i = 1; i <= N; i++)
                graph[i] = new ArrayList<>();

            for(int i = 0 ; i < M ; i ++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph[a].add(new Node(b, d));
                graph[b].add(new Node(a, d));
            }

            int[] dist1 = dijkstra(S);
            int[] dist2 = dijkstra(G);
            int[] dist3 = dijkstra(H);

            int[] tArr = new int[T];
            for(int i = 0 ; i < T ; i ++)
                tArr[i] = Integer.parseInt(br.readLine());
            Arrays.sort(tArr);

            for(int i = 0 ; i < T ; i ++) {
                if(dist1[tArr[i]] == dist1[G] + dist2[H] + dist3[tArr[i]] || dist1[tArr[i]] == dist1[H] + dist3[G] + dist2[tArr[i]]){
                    sb.append(tArr[i]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    private static int[] dijkstra(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        pq.offer(new Node(s, 0));
        while(!pq.isEmpty()){
            Node currNode = pq.poll();
            int cur = currNode.node;

            if(currNode.dist > dist[cur]) continue;

            for(Node next: graph[cur]){
                if(dist[next.node] > dist[cur] + next.dist){
                    dist[next.node] = dist[cur] + next.dist;
                    pq.offer(new Node(next.node, dist[next.node]));
                }
            }
        }
        return dist;
    }
}