import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[][] dist;
    static char[][] map;
    static Queue<Node> treeList;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dist = new int[R][C];
        map = new char[R][C];
        treeList = new ArrayDeque<>();

        int sr = 0, sc = 0, er = 0, ec = 0;
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'V'){
                    sr = i;
                    sc = j;
                }
                else if(map[i][j] == 'J'){
                    er = i;
                    ec = j;
                }
                else if(map[i][j] == '+'){
                    dist[i][j] = 0;
                    treeList.offer(new Node(i, j, 0));
                }
            }
        }

        treeDijkstra(); // 1. 나무에서 각 좌표의 최단거리 구하기
        System.out.println(dijkstra(sr, sc, er, ec)); // 2. 시작점(V)에서 종료점(J)까지의 최장거리 구하기
    }

    private static void treeDijkstra() {
        while(!treeList.isEmpty()){
            Node curr = treeList.poll();

            for(int d = 0 ; d < 4 ; d ++){
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if(!isValid(nr, nc)) continue;
                if(dist[nr][nc] > curr.d + 1){
                    dist[nr][nc] = curr.d + 1;
                    treeList.offer(new Node(nr, nc, dist[nr][nc]));
                }
            }
        }
    }

    private static int dijkstra(int sr, int sc, int er, int ec) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o2.d - o1.d));
        boolean[][] v = new boolean[R][C];
        v[sr][sc] = true;
        int min = Integer.MAX_VALUE;
        pq.offer(new Node(sr, sc, dist[sr][sc]));
        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if(min > curr.d) min = curr.d;

            if(curr.d < dist[curr.r][curr.c]) continue;

            if(curr.r == er && curr.c == ec) return min;

            for(int d = 0 ; d < 4 ; d ++){
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if(!isValid(nr, nc) || v[nr][nc]) continue;
                v[nr][nc] = true;
                pq.offer(new Node(nr, nc, dist[nr][nc]));
            }
        }
        return 0;
    }

    private static boolean isValid(int nr, int nc) {
        return (nr>=0 && nr<R && nc>=0 && nc<C);
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