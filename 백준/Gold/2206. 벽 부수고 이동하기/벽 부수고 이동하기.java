import java.io.*;
import java.util.*;
public class Main {
    static int N, M, ans, INF = Integer.MAX_VALUE;
    static boolean[][][] v;
    static int[][] map;

    static class Node {
        int r;
        int c;
        int d;
        boolean flag;

        Node(int r, int c, int d, boolean flag) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.flag = flag;
        }
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        ans = bfs();
        System.out.println(ans == INF ? -1 : ans+1);
    }

    private static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 0, true));
        v = new boolean[N][M][2];
        v[0][0][0] = true;
        int res = INF;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if(curr.r == N-1 && curr.c == M-1){
                res = curr.d;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = dr[d] + curr.r;
                int nc = dc[d] + curr.c;

                if (!isValid(nr, nc)) continue;

                if(curr.flag){
                    if(!v[nr][nc][1] && map[nr][nc] == 1){
                        q.offer(new Node(nr, nc, curr.d + 1, false));
                        v[nr][nc][1] = true;
                    }
                    else if(!v[nr][nc][0] && map[nr][nc] == 0){
                        q.offer(new Node(nr, nc, curr.d + 1, curr.flag));
                        v[nr][nc][0] = true;
                    }
                }
                else{
                    if(!v[nr][nc][1] && map[nr][nc] == 0){
                        q.offer(new Node(nr, nc, curr.d + 1, curr.flag));
                        v[nr][nc][1] = true;
                    }
                }
            }
        }

        return res;
    }
    private static boolean isValid(int nr, int nc) {
        return (nr >= 0 && nr < N && nc >= 0 && nc < M);
    }
}