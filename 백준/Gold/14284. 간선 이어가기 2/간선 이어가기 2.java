import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[] dist;
    static List<Node>[] list;
    static class Node{
        int n;
        int d;
        public Node(int n, int d){
            this.n = n;
            this.d = d;
        }
    }
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        list = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i ++)
            list[i] = new ArrayList<>();

        for(int i = 0 ; i < M ; i ++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, d));
            list[b].add(new Node(a, d));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dijkstra(s);
        System.out.println(dist[e]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        while(!pq.isEmpty()){
            Node currNode = pq.poll();
            int curr = currNode.n;

            if(currNode.d > dist[curr]) continue;

            for(Node next: list[curr]){
                if(dist[next.n] > dist[curr] + next.d){
                    dist[next.n] = dist[curr] + next.d;
                    pq.offer(new Node(next.n, dist[next.n]));
                }
            }
        }
    }
}