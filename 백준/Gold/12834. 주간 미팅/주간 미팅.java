import java.io.*;
import java.util.*;

public class Main {
    static int INF = Integer.MAX_VALUE;
    static int N, M, E;
    static int[] dest;
    static int[] mans;
    static boolean[] v;
    static int[] dist;
    static List<Node>[] list;

    static class Node {
        int from;
        int dist;

        public Node(int from, int dist) {
            this.from = from;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[M + 1];
        dest = new int[2];
        mans = new int[N];

        for (int i = 1; i <= M; i++) list[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2; i++) dest[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) mans[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, d));
            list[b].add(new Node(a, d));
        }

        long ans = 0;
        for (int i = 0; i < N; i++) {
            int curr = mans[i];

            dist = new int[M + 1];
            Arrays.fill(dist, INF);

            dijkstra(curr);

            for (int j = 0; j < 2; j++) {
                if (dist[dest[j]] != INF) ans += dist[dest[j]];
                else ans -= 1;
            }
        }
        System.out.println(ans);

    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node currNode = pq.poll();
            int curr = currNode.from;

            for (Node next : list[curr]) {
                if (dist[next.from] > dist[curr] + next.dist) {
                    dist[next.from] = dist[curr] + next.dist;
                    pq.offer(next);
                }
            }
        }
    }
}