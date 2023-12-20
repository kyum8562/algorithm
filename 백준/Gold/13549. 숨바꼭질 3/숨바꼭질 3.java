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
        System.out.println(min);
    }

    private static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(N, 0, v));

        while (!q.isEmpty()) {
            Node currNode = q.poll();
            int curr = currNode.node;
            int dist = currNode.dist;
            boolean[] currV = currNode.v;

            currV[curr] = true;

            if (curr == K) min = Math.min(min, dist);

            for (int d = 0; d < 3; d++) {
                int next = curr;

                if (d == 0) next *= 2;
                else if (d == 1) next += 1;
                else next -= 1;

                if (!isValid(next)) continue;

                if (!currV[next]) {
                    q.offer(new Node(next, d==0 ? dist: dist+1, currV));
                }
            }
        }
    }
    static class Node{
        int node;
        int dist;
        boolean[] v;
        public Node(int node, int dist, boolean[] v){
            this.node = node;
            this.dist = dist;
            this.v = v;
        }
    }

    private static boolean isValid(int next) {
        return (next >= 0 && next <= 100000);
    }
}