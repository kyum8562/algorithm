import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static final int INF = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        v = new boolean[N][M];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] s = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = s[j] - '0';
            }
        }

        dijkstra();
    }

    private static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
        v[0][0] = true;
        q.offer(new Node(0, 0, 0));

        while (!q.isEmpty()) {
            Node curr = q.poll();
            int r = curr.r;
            int c = curr.c;

            if(r == N-1 && c == M-1){
                System.out.println(curr.d);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = dr[d] + r;
                int nc = dc[d] + c;

                if (!isValid(nr, nc) || v[nr][nc]) continue;
                v[nr][nc] = true;
                q.offer(new Node(nr, nc, map[nr][nc] == 0 ? curr.d : curr.d + 1));
            }
        }
    }

    private static boolean isValid(int nr, int nc) {
        return (nr >= 0 && nr < N && nc >= 0 && nc < M);
    }
}