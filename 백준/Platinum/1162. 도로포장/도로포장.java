import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static long MAX = Long.MAX_VALUE;
    static long[][] dist;
    static List<Node>[] graph;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new long[N+1][K+1];
        graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i ++){
            Arrays.fill(dist[i], MAX);
            graph[i] = new ArrayList<>();
        }

        for(int i = 1 ; i <= M ; i ++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, d, 0));
            graph[e].add(new Node(s, d, 0));
        }
        // 기본적으로, M개의 가중치를 한번씩 바꿔주면 되긴 함
        dijkstra();
        Arrays.sort(dist[N]);
        System.out.println(dist[N][0]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (int) (o1.cost - o2.cost));
        dist[1][0] = 0;
        pq.offer(new Node(1, 0, 0));

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            if(curr.cost > dist[curr.n][curr.usingK]) continue;

            for(Node next: graph[curr.n]){
                // [포장 O] K를 더 사용할 수 있고, dist 배열 갱신이 가능하다면
                if(K > curr.usingK && dist[next.n][curr.usingK+1] > curr.cost){
                    dist[next.n][curr.usingK+1] = curr.cost;
                    pq.offer(new Node(next.n, curr.cost, curr.usingK+1));
                }
                // [포장 X]
                if(dist[next.n][curr.usingK] > curr.cost+next.cost){
                    dist[next.n][curr.usingK] = curr.cost+next.cost;
                    pq.offer(new Node(next.n, curr.cost+next.cost, curr.usingK));
                }
            }
        }
    }
    static class Node{
        int n, usingK;
        long cost;
        public Node(int n, long cost, int usingK){
            this.n = n;
            this.cost = cost;
            this.usingK = usingK;
        }
    }
}