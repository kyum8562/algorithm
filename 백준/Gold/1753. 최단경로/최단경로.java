import java.io.*;
import java.util.*;

class Main {
    static final int INF = 1 << 30;
    static int[] dist;
    static List<Node>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(br.readLine());

        dist = new int[N+1];
        list = new ArrayList[N+1];

        for(int i = 1 ; i <= N ;i ++){
            list[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, d));
        }

        dijkstra(S);

        for(int i = 1 ; i <= N ; i ++)
            sb.append(dist[i] == INF ? "INF" : dist[i]).append("\n");

        System.out.println(sb);
    }

    private static void dijkstra(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);

        dist[s] = 0;
        pq.offer(new Node(s, 0));

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.n;

            if(curNode.d > dist[cur])
                continue;

            for(Node next: list[cur]){
                if(dist[next.n] > dist[cur] + next.d){
                    dist[next.n] = dist[cur] + next.d;
                    pq.offer(new Node(next.n, dist[next.n]));
                }
            }
        }
    }

    static class Node{
        int n;
        int d;
        public Node(int n, int d){
            this.n = n;
            this.d = d;
        }
    }

}