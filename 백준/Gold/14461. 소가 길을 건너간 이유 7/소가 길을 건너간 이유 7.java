import java.io.*;
import java.util.*;

public class Main {
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
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
        boolean[][][] v = new boolean[N][N][3];
        q.offer(new Node(0, 0, 0, 0));

        while(!q.isEmpty()) {
            Node curr = q.poll();

            if(v[curr.r][curr.c][curr.move]) continue;
            v[curr.r][curr.c][curr.move] = true;

            if(curr.r == N-1 && curr.c == N-1){
                System.out.println(curr.d);
                return;
            }

            for(int d = 0 ; d < 4 ; d ++){
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if(!isValid(nr, nc) || v[nr][nc][(curr.move+1)%3]) continue;

                if(curr.move == 2) q.offer(new Node(nr, nc, 0, curr.d + map[nr][nc] + T));
                else q.offer(new Node(nr, nc, curr.move + 1, curr.d + T));
            }
        }
    }
    static boolean isValid(int nr, int nc){
        return(nr>=0 && nr<N && nc>=0 && nc<N);
    }
    static class Node{
        int r, c, move, d;
        public Node(int r, int c, int move, int d){
            this.r = r;
            this.c = c;
            this.move = move;
            this.d = d;
        }
    }
}