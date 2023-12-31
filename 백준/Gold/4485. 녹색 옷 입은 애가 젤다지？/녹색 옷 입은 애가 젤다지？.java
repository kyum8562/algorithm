import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[][] dist;
    static int INF = Integer.MAX_VALUE;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] v;
    static class Node {
        int r;
        int c;
        int dist;

        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N == 0) return;

            map = new int[N][N];
            dist = new int[N][N];
            v = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = INF;
                }
            }

            bfs(0,0);

            System.out.println("Problem " + (cnt++) + ": " + dist[N-1][N-1]);
        }
    }

    private static void bfs(int a, int b) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        dist[a][b] = map[0][0];
        v[a][b] = true;
        pq.offer(new Node(a, b, map[0][0]));

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            for(int d = 0 ; d < 4 ; d ++){
                int nr = dr[d] + curr.r;
                int nc = dc[d] + curr.c;
                if(nr >= 0 && nr < N && nc >= 0 && nc < N){
                    if(!v[nr][nc] && dist[nr][nc] > curr.dist + map[nr][nc] ){
                        dist[nr][nc] = dist[curr.r][curr.c] + map[nr][nc];
                        v[nr][nc] = true;
                        pq.offer(new Node(nr, nc, dist[nr][nc]));
                    }
                }
            }
        }
    }
}