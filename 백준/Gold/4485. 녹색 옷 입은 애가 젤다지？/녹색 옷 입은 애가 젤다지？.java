import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int INF = Integer.MAX_VALUE;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] v;
    static class Node {
        int r;
        int c;
        int cost;

        public Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N == 0) break;

            map = new int[N][N];
            v = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            sb.append("Problem " + (cnt++) + ": " + bfs()).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        v[0][0] = true;
        pq.offer(new Node(0, 0, map[0][0]));

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            if(curr.r == N-1 && curr.c == N-1){
                return curr.cost;
            }

            for(int d = 0 ; d < 4 ; d ++){
                int nr = dr[d] + curr.r;
                int nc = dc[d] + curr.c;

                if(!isValid(nr, nc) || v[nr][nc]) continue;
                v[nr][nc] = true;

                pq.offer(new Node(nr, nc, curr.cost + map[nr][nc]));
            }
        }
        return 0;
    }

    private static boolean isValid(int nr, int nc) {
        return (nr >= 0 && nr < N && nc >= 0 && nc < N);
    }
}