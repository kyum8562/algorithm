import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int min = Integer.MAX_VALUE;
    static boolean[] v;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[100001];
        v = new boolean[100001];

        bfs();
//        dfs(new Node(N, 0));
        System.out.println(min);
    }

//    private static void dfs(Node currNode) {
//        int cur = currNode.node;
//        int dist = currNode.dist;
//
//        if (!isValid(cur)) return;
//        if (cur == K) min = Math.min(min, dist);
//
//        dfs(new Node(cur*2, dist));
//        dfs(new Node(cur+1, dist+1));
//        dfs(new Node(cur-1, dist+1));
//    }

    private static void bfs() {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        q.offer(new Node(N, 0));

        while (!q.isEmpty()) {
            Node currNode = q.poll();
            int curr = currNode.node;
            int dist = currNode.dist;

            v[curr] = true;

            if (curr == K){
                min = Math.min(min, dist);
                return;
            }

            for (int d = 0; d < 3; d++) {
                int next = curr;

                if (d == 0) next *= 2;
                else if (d == 1) next += 1;
                else next -= 1;

                if (!isValid(next)) continue;

                if (!v[next]) {
                    q.offer(new Node(next, d==0 ? dist: dist+1));
                }
            }
        }
    }
    static class Node{
        int node;
        int dist;
        public Node(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }

    private static boolean isValid(int next) {
        return (next >= 0 && next <= 100000);
    }
}