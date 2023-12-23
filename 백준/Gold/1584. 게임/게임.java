import java.io.*;
import java.util.*;

public class Main {
    static int INF = Integer.MAX_VALUE;
    static int[][] map = new int[501][501];
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());

            marking(sr, sc, er, ec, 1);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());

            marking(sr, sc, er, ec, 2);
        }

        System.out.println(dijkstra());
    }
    private static void marking(int x1, int y1, int x2, int y2, int mark) {
        int xs = x1<x2?x1:x2;
        int xe = x1<x2?x2:x1;
        int ys = y1<y2?y1:y2;
        int ye = y1<y2?y2:y1;

        for (int i = xs; i <= xe; i++) {
            for (int j = ys; j <= ye; j++) {
                map[i][j] = mark;
            }
        }
    }

    private static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o1.d - o2.d));
        int[][] dist = new int[501][501];
        for(int i = 0 ; i <= 500 ; i ++)
            Arrays.fill(dist[i], INF);
        pq.offer(new Node(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            for (int d = 0; d < 4; d++) {
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if (!isValid(nr, nc) || map[nr][nc] == 2) continue;
                if(dist[nr][nc] > curr.d + map[nr][nc]){
                    dist[nr][nc] = curr.d + map[nr][nc];
                    if(map[nr][nc] == 0)
                        pq.offer(new Node(nr, nc, curr.d));
                    else
                        pq.offer(new Node(nr, nc, curr.d+1));
                }
            }
        }
        return dist[500][500] == INF ? -1 : dist[500][500];
    }

    private static boolean isValid(int nr, int nc) {
        return (nr >= 0 && nr < 501 && nc >= 0 && nc < 501);
    }

    static class Node {
        int r;
        int c;
        int d;

        public Node(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}