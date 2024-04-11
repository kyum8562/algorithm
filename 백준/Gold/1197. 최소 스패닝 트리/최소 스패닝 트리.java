import java.io.*;
import java.util.*;

public class Main {
    static int V, E, ans;
    static List<Node>[] graph;
    static boolean[] v;
    static class Node{
        int node;
        int dist;
        public Node(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];
        v = new boolean[V+1];

        for(int i = 1 ; i <= V ; i ++) graph[i] = new ArrayList<>();

        for(int i = 1 ; i <= E ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, d));
            graph[b].add(new Node(a, d));
        }
        
        prim(1);
        System.out.println(ans);
    }

    private static void prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>( (o1, o2) -> o1.dist - o2.dist);

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int node = curr.node;
            int dist = curr.dist;

            if(v[node]) continue;
            v[node] = true;
            ans += dist;

            for(Node next: graph[node]){
                if(!v[next.node]) pq.add(next);
            }

        }

    }
}