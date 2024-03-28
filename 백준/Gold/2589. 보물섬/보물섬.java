import java.io.*;
import java.util.*;

class Main {
    static final int INF = 1 << 30;
    static int R, C, res;
    static char[][] arr;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        res = 0;

        arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == 'W') continue;

                v = new boolean[R][C];
                bfs(i, j);
            }
        }

        System.out.println(res);
    }

    private static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();

        v[r][c] = true;
        int cnt = -1;

        q.offer(new int[]{r, c});

        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {

                int[] cur = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];

                    if (!isValid(nr, nc) || v[nr][nc] || arr[nr][nc] == 'W') continue;

                    v[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }

            cnt ++;
        }

        res = Math.max(res, cnt);
    }

    private static boolean isValid(int nr, int nc) {
        return (nr >= 0 && nr < R && nc >= 0 && nc < C);
    }
}