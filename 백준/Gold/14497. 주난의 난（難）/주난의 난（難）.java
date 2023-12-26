import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int INF = Integer.MAX_VALUE;
    static int N, M, startR, startC, endR, endC;
    static char[][] map;
    static boolean[][] v;

    static class Node {
        int r;
        int c;
        int time;

        public Node(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        v = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        startR = Integer.parseInt(st.nextToken()) - 1;
        startC = Integer.parseInt(st.nextToken()) - 1;
        endR = Integer.parseInt(st.nextToken()) - 1;
        endC = Integer.parseInt(st.nextToken()) - 1;

        for(int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();

        System.out.println(dijkstra());
    }

    private static int dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        q.offer(new Node(startR, startC, 0));
        v[startR][startC] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.r == endR && curr.c == endC) return curr.time;

            for (int d = 0; d < 4; d++) {
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if (!isValid(nr, nc) || v[nr][nc]) continue;

                v[nr][nc] = true;

                q.offer(new Node(nr, nc, map[nr][nc] == '0' ? curr.time : curr.time+1));
            }
        }
        return 0;
    }


    private static boolean isValid(int nr, int nc) {
        return (nr >= 0 && nr < N && nc >= 0 && nc < M);
    }
}