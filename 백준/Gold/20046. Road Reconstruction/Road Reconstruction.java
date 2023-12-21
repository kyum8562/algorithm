import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static List<int[]>[] list;
//    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int sr, int sc) {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[sr][sc] = map[sr][sc];
        q.offer(new Node(sr, sc, 0));
        while(!q.isEmpty()){
            Node curr = q.poll();

            if(curr.d > dist[curr.r][curr.c]) continue;
            if(curr.r == N-1 && curr.c == M-1){
                return curr.d;
            }

            for(int d = 0 ; d < 4 ; d ++){
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                // 범위를 벗어났을 때, 갈 수없는 벽(-1)일 때, 방문한 배열일 때 continue;
                if(!isValid(nr, nc) || map[nr][nc] == -1) continue;
                if(dist[nr][nc] > dist[curr.r][curr.c] + map[nr][nc]){
                    dist[nr][nc] = dist[curr.r][curr.c] + map[nr][nc];
                    q.offer(new Node(nr, nc, dist[nr][nc]));
                }
            }
        }
        return dist[N-1][M-1] == Integer.MAX_VALUE ? -1 : dist[N-1][M-1];
    }
    static boolean isValid(int nr, int nc){
        return(nr>=0 && nr<N && nc>=0 && nc<M);
    }
    static class Node{
        int r, c, d;
        public Node(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}