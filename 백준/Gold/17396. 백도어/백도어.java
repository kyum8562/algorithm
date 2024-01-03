import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static Long INF = Long.MAX_VALUE;
    static long[] dist;
    static int[] v;
    static List<Node>[] list;
    static class Node implements Comparable<Node>{
        int n;
        long d;
        public Node(int n, long d){
            this.n = n;
            this.d = d;
        }

        @Override
        public int compareTo(Node o){
            if(this.d - o.d > 0) return 1;
            else return -1;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        v = new int[N+1];
        dist = new long[N+1];
        list = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i ++)
            list[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
//        for(int i = 1 ; i <= N ; i ++)
//            isOpen[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            int t = Integer.parseInt(st.nextToken());
            if (i!=N) v[i] = t;
        }

        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())+1;
            int b = Integer.parseInt(st.nextToken())+1;
            int d = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, d));
            list[b].add(new Node(a, d));
        }

        long res = dijkstra(1);
        System.out.println(res == INF ? -1 : res);
    }

    private static long dijkstra(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));

        Arrays.fill(dist, INF);
        dist[s] = 0;

        while(!pq.isEmpty()){
            Node currNode = pq.poll();
            int curr = currNode.n;

            if(currNode.d > dist[curr]) continue;
            v[curr] = 1;

            for(Node next: list[curr]){
                if(v[next.n] == 1) continue;
                if(dist[next.n] > dist[curr] + next.d){
                    dist[next.n] = dist[curr] + next.d;
                    pq.offer(new Node(next.n, dist[next.n]));
                }
            }
        }

        return dist[N];
    }
}