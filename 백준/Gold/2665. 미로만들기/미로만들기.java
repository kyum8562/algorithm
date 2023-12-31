import java.io.*;
import java.util.*;

public class Main {
    static int INF = Integer.MAX_VALUE;
    static int N, M;
    static char[][] map;
    static boolean[][] v;
    static PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
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
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        v = new boolean[N][N];

        for (int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();

        v[0][0] = true;
        q.offer(new Node(0, 0, 0));

        bfs();
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Node curr = q.poll();

            if(curr.r == N-1 && curr.c == N-1){
                System.out.println(curr.d);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = dr[d] + curr.r;
                int nc = dc[d] + curr.c;

                if (!isValid(nr, nc) || v[nr][nc]) continue;
                v[nr][nc] = true;
                q.offer(new Node(nr, nc, map[nr][nc] == '1' ? curr.d : curr.d +1));
            }
        }
    }

    private static boolean isValid(int nr, int nc) {
        return (nr >= 0 && nr < N && nc >= 0 && nc < N);
    }
}