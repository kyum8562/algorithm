import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dist;
    static List<Node>[] graph;
    static boolean[] v;
    static class Node implements Comparable<Node>{
        int end;
        int dist;
        public Node(int end, int dist){
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o){
            return o.dist - this.dist;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i ++) graph[i] = new ArrayList<>();

        for(int i = 1 ; i <= M ; i ++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, d));
            graph[e].add(new Node(s, d));
        }

        int res = Integer.MIN_VALUE;
        res = Math.max(res, prim(1));

        boolean flag = true;
        for(int i = 1 ; i <= N ; i ++){
            if(!v[i]){
                flag = false;
                break;
            }
        }

        System.out.println(flag ? res : -1);
    }

    private static int prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        v = new boolean[N+1];
        int ans = 0;

        while(!pq.isEmpty()){
            Node currNode = pq.poll();
            int curr = currNode.end;

            if(v[curr]) continue;
            v[curr] = true;
            ans += currNode.dist;

            for(Node next: graph[curr]){
                if(!v[next.end]){
                    pq.offer(next);
                }
            }
        }
        return ans;
    }
}