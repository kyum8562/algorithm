import java.io.*;
import java.util.*;

class Main {
    static int R, C;
    static int[][] arr;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        v = new boolean[R][C];

        for(int i = 0 ; i < R ; i ++){
            String s = br.readLine();
            for(int j = 0 ; j < C ; j ++)
                arr[i][j] = s.charAt(j) - '0';
        }

        bfs();
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();

        int cnt = 1;

        v[0][0] = true;
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int qSize = q.size();

            for (int i = 0 ; i < qSize ; i++) {
                int[] cur = q.poll();

                if (cur[0] == R-1 && cur[1] == C-1) {
                    System.out.println(cnt);
                    return;
                }

                for(int d = 0 ; d < 4 ; d ++){
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];

                    if(!isValid(nr, nc) || v[nr][nc] || arr[nr][nc] == 0) continue;

                    v[nr][nc] = true;
                    q.offer(new int[]{nr, nc});

                }
            }

            cnt++;
        }
    }

    private static boolean isValid(int nr, int nc) {
        return (nr>=0 && nr<R && nc>=0 && nc<C);
    }
}