import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[] dist;
    static int[] route;
    static List<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc = 1 ; tc <= T ; tc ++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N+1];
            dist = new int[N+1];
            route = new int[N+1];
            for(int i = 1 ; i <= N ; i ++){
                graph[i] = new ArrayList<>();
                dist[i] = Integer.MAX_VALUE;
            }

            for(int i = 0 ; i < M ; i ++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) + 1;
                int b = Integer.parseInt(st.nextToken()) + 1;
                int d = Integer.parseInt(st.nextToken());

                graph[a].add(new Node(b, d));
                graph[b].add(new Node(a, d));
            }

            dijkstra(1);

            boolean flag = check();
            if(flag){
                sb.append("Case #"+tc+": ");

                int cur = N;
                List<Integer> res = new ArrayList<>();
                while(cur != 0){
                    res.add(cur);
                    cur = route[cur];
                }
                for (int i = res.size() -1; i >= 0 ; i--)
                    sb.append(res.get(i)-1 + " ");
                sb.append("\n");
            }
            else sb.append("Case #"+tc+": "+ "-1");
        }
        System.out.println(sb);
    }

    private static boolean check() {
        for(int i = 1 ; i<= N ; i ++)
            if(dist[i] == Integer.MAX_VALUE) return false;
        return true;
    }

    private static void dijkstra(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o1.d - o2.d));
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
        int d;
        public Node(int n, int d){
            this.n = n;
            this.d = d;
        }
    }
}