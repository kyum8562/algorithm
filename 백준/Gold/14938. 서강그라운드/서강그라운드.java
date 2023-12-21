import java.io.*;
import java.util.*;
public class Main {
    static int INF = Integer.MAX_VALUE;
    static int N, M, K;
    static int[] dist;
    static int[] items;
    static boolean[] v;
    static List<Node>[] graph;
    static class Node implements Comparable<Node>{
        int node;
        int dist;
        public Node(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
        @Override
        public int compareTo(Node o){
            return this.dist - o.dist;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        items = new int[N+1];
        dist = new int[N+1];
        graph = new ArrayList[N+1];


        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i ++)
            items[i] = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= N ; i ++)
            graph[i] = new ArrayList<>();

        for(int i = 1 ; i <= M ; i ++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, d));
            graph[e].add(new Node(s, d));
        }

        int ans = 0;
        for(int i = 1 ; i <= N ; i ++){
            Arrays.fill(dist, INF);
            v = new boolean[N+1];
            dijkstra(i);

            int sum = 0;
            for(int j = 1 ; j <= N ; j ++){
                if(dist[j] <= K) sum += items[j];
            }

            ans = Math.max(ans, sum);
        }




        System.out.println(ans);
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