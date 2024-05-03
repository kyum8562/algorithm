import java.io.*;
import java.util.*;

class Main {
    static int N, T;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
    }

    private static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][][] v = new boolean[N][N][3];
        pq.offer(new Node(0, 0, 0, 0)); // r, c, d, moveCnt

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(v[cur.r][cur.c][cur.moveCnt]) continue;
            v[cur.r][cur.c][cur.moveCnt] = true;

            if(cur.r == N-1 && cur.c == N-1){
                System.out.println(cur.d);
                return;
            }

            for(int d = 0 ; d < 4 ; d ++){
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if(!isValid(nr, nc) || v[nr][nc][(cur.moveCnt+1)%3]) continue;

                if(cur.moveCnt == 2)
                    pq.offer(new Node(nr, nc, cur.d + T + map[nr][nc], 0));
                else
                    pq.offer(new Node(nr, nc, cur.d + T, cur.moveCnt+1));

            }
        }
    }
    static boolean isValid(int nr, int nc){
        return (nr>=0 && nr<N && nc>=0 && nc<N);
    }

    static class Node implements Comparable<Node>{
        int r, c, d, moveCnt;

        public Node(int r, int c, int d, int moveCnt){
            this.r = r;
            this.c = c;
            this.d = d;
            this.moveCnt = moveCnt;
        }

        @Override
        public int compareTo(Node o){
            return this.d - o.d;
        }
    }
}