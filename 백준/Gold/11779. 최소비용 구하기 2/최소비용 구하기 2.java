import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static long[] dist;
    static int[] route;
    static List<Node>[] graph, graph2;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        R = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        graph = new ArrayList[R+1];
        graph2 = new ArrayList[R+1];
        dist = new long[R+1];
        route = new int[R+1];
        for(int i = 1 ; i <= R ; i ++){
            graph[i] = new ArrayList<>();
            graph2[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0 ; i < C ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, d));
            graph2[b].add(new Node(a, d));
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        dijkstra(s);
        int cur = e;
        List<Integer> res = new ArrayList<>();
        while(route[cur] != 0){
            res.add(cur);
            cur = route[cur];
        }
        res.add(s);

        System.out.println(dist[e]);
        System.out.println(res.size());

        for (int i = res.size() -1; i >= 0 ; i--) {
            System.out.print(res.get(i) + " ");
        }
    }

    private static void dijkstra(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (int) (o1.d - o2.d));
        dist[s] = 0;
        pq.offer(new Node(s, 0));
        while(!pq.isEmpty()){
            Node curr = pq.poll();

            if(curr.d > dist[curr.n]) continue;

            for(Node next: graph[curr.n]){
                if(dist[next.n] > dist[curr.n] + next.d){
                    dist[next.n] = dist[curr.n] + next.d;

                    pq.offer(new Node(next.n, dist[next.n]));
                    route[next.n] = curr.n;
                }
            }
        }
    }
    static class Node{
        int n;
        long d;
        public Node(int n, long d){
            this.n = n;
            this.d = d;
        }
    }
}