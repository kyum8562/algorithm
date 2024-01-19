import java.io.*;
import java.util.*;

public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static List<Node>[] list;
    static long[][] map;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine()); // 정점의 개수

            map = new long[N + 1][2];
            v = new boolean[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++)
                map[i][0] = Long.parseLong(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++)
                map[i][1] = Long.parseLong(st.nextToken());

            double tax = Double.parseDouble(br.readLine());

            list = new ArrayList[N + 1];
            for(int i = 1 ; i <= N ; i ++)
                list[i] = new ArrayList<>();

            for(int i = 1 ; i <= N ; i ++){
                for(int j = i + 1 ; j <= N ; j ++){
                    long d = (long) (Math.pow(map[i][0] - map[j][0], 2) + Math.pow(map[i][1] - map[j][1], 2));
                    list[i].add(new Node(j, d));
                    list[j].add(new Node(i, d));
                }
            }

            sb.append("#").append(t).append(" ");
            sb.append(Math.round(dijkstra(1) * tax)).append("\n");
        }

        System.out.println(sb);
    }

    private static long dijkstra(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));

        long cost = 0;
        int nodeCnt = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curN = cur.n;

            if(v[curN]) continue;
            v[curN] = true;
            cost += cur.d;

            if(++nodeCnt == N) break;

            for(Node next: list[curN]){
                if(v[next.n]) continue;
                pq.offer(new Node(next.n, next.d));
            }
        }

        return cost;
    }
    static class Node implements Comparable<Node>{
        int n;
        long d;
        public Node(int n, long d){
            this.n = n;
            this.d = d;
        }

        @Override
        public int compareTo(Node o){
            return Long.compare(this.d, o.d);
        }
    }
}