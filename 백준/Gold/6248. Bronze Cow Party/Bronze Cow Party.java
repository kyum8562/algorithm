import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for (int i = 1; i <= N ; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, d));
            list[b].add(new Node(a, d));
        }

        System.out.println(dijkstra(X));
    }

    private static int dijkstra(int s) {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
        int[] dist = new int[N+1];
        for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;
        dist[s] = 0;
        q.offer(new Node(s, 0));
        while(!q.isEmpty()){
            Node curr = q.poll();

            if(curr.d > dist[curr.n]) continue;

            for(Node next: list[curr.n]){
                if(dist[next.n] > dist[curr.n] + next.d){
                    dist[next.n] = dist[curr.n] + next.d;
                    q.offer(new Node(next.n, dist[next.n]));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1 ; i <= N ; i ++)
            max = Math.max(max, dist[i]);
        return max*2;
    }
    static class Node{
        int n, d;
        public Node(int n, int d){
            this.n = n;
            this.d = d;
        }
    }
}