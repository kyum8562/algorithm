import java.io.*;
import java.util.*;

class Main {
    static int N, M, zeroCnt;
    static int[][] arr;
    static Queue<Node> q = new ArrayDeque<>();
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        boolean flag = true;

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                arr[i][j] = tmp;
                if (tmp == 0) {
                    flag = false;
                    zeroCnt++;
                } else if (tmp == 1)
                    q.offer(new Node(i, j));
            }
        }

        if (flag) System.out.println(0);
        else System.out.println(bfs());
        
    }

    private static int bfs() {
        int max = - (1 << 30);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isValid(nr, nc) || arr[nr][nc] != 0) continue;

                q.offer(new Node(nr, nc));
                arr[nr][nc] = arr[cur.r][cur.c] + 1;
                max = Math.max(max, arr[nr][nc]);
                zeroCnt --;
            }
        }

        return zeroCnt == 0 ? max-1 : -1;
    }

    private static boolean isValid(int nr, int nc) {
        return (nr >= 0 && nr < N && nc >= 0 && nc < M);
    }

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}