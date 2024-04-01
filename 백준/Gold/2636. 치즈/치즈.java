import java.io.*;
import java.util.*;

public class Main {
    static int N, M, melt, cheese = 0;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static class Node {
        int r;
        int c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        v = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) cheese ++;
            }
        }

        int time = 0;

        while (cheese != 0) {

            time++;

            melt = 0;

            // bfs 탐색: 가장자리 치즈 탐색
            bfs(0, 0);

            // 치즈 제거
            removeCheese();

            // 방문 초기화
            v = new boolean[N][M];

            // cheese 업데이트
            cheese -= melt;
        }

        System.out.println(time);
        System.out.println(melt);

    }
    private static void bfs(int i, int j) {
        Queue<Node> q = new ArrayDeque<>();
        v[i][j] = true;
        q.offer(new Node(i, j));

        while (!q.isEmpty()) {
            Node curr = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if (!isValid(nr, nc)) continue;
                if (v[nr][nc]) continue;

                v[nr][nc] = true;

                // 다음 방문할 곳: 치즈
                if (map[nr][nc] == 1) map[nr][nc] = 2;
                    // 다음 방문할 곳: 빈 공간
                else q.offer(new Node(nr, nc));
            }
        }
    }
    private static void removeCheese() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 2){
                    map[i][j] = 0;
                    melt ++;
                }
            }
        }
    }
    private static boolean isValid(int nr, int nc) {
        return (nr >= 0 && nr < N && nc >= 0 && nc < M);
    }
}