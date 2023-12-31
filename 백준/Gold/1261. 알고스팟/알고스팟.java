import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static final int INF = Integer.MAX_VALUE;
    static int[][] v, map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        v = new int[N][M];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] s = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = s[j] - '0';
            }
        }

        for (int i = 0; i < N; i++) Arrays.fill(v[i], INF);

        dijkstra();

        System.out.println(v[N - 1][M - 1]);
    }

    private static void dijkstra() {
        Queue<Node> q = new ArrayDeque<>();
        v[0][0] = 0;
        q.offer(new Node(0, 0));

        while (!q.isEmpty()) {
            Node curr = q.poll();
            int r = curr.r;
            int c = curr.c;

            for (int d = 0; d < 4; d++) {
                int nr = dr[d] + r;
                int nc = dc[d] + c;

                if (isValid(nr, nc)) {
                    if (v[nr][nc] > v[r][c] + map[nr][nc]) {
                        v[nr][nc] = v[r][c] + map[nr][nc];
                        q.offer(new Node(nr, nc));
                    }
                }
            }
        }
    }

    private static boolean isValid(int nr, int nc) {
        return (nr >= 0 && nr < N && nc >= 0 && nc < M);
    }
}