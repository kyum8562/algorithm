import java.io.*;
import java.util.*;

public class Main {
    static int N, D;
    static List<Node>[] graph;
    static int[] dist;

    static class Node {
        int node;
        int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        graph = new ArrayList[10001];
        dist = new int[10001];

        for (int i = 0; i <= 10000 ; i++){
            graph[i] = new ArrayList<>();
            dist[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[v1].add(new Node(v2, d));
        }

        dijkstra(0);
        System.out.println(dist[D]);
    }

    private static void dijkstra(int start) {
       if(start > D) return;

       if(dist[start+1] > dist[start] + 1)
           dist[start+1] = dist[start] + 1;

        for (Node next : graph[start]) {
            if (dist[next.node] > dist[start] + next.dist) {
                dist[next.node] = dist[start] + next.dist;
            }
        }

        dijkstra(start + 1);
    }
}