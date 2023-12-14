import java.io.*;
import java.util.*;

public class Main {
    static int N, iceSum = 0;
    static boolean[][] v;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        N = (int) Math.pow(2, N);
        map = new int[N][N];
        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                iceSum += map[i][j];
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int L = Integer.parseInt(st.nextToken());

            rotation90(L);//2^L * 2^L 격자로 나누고 + 90도 시계방향 회전

            meltingIce(); //얼음감소(iceSum 빼줘야 함)
        }

        v = new boolean[N][N];
        int largestIceBlock = 0;
        for(int i = 0 ; i < N ; i ++){
            for (int j = 0; j < N; j++) {
                if(v[i][j] || map[i][j] <= 0) continue;
                v[i][j] = true;
                largestIceBlock = Math.max(largestIceBlock, bfs(i, j));
            }
        }
        System.out.println(iceSum);
        System.out.println(largestIceBlock);
    }

    private static void rotation90(int L) {
        int[][] tmp = new int[N][N];
        int M = (int) Math.pow(2, L); // 2^L

        for(int a = 0 ; a < N ; a += M){
            for(int b = 0 ; b < N ; b += M) {
                for (int i = a; i < a + M; i++) {
                    for (int j = b; j < b + M; j++) {
                        tmp[i][j] = map[a+b+M-1-j][b+i-a];
                    }
                }
            }
        }
        map = tmp;
    }

    private static void meltingIce() {
        int[][] tmp = new int[N][N];
        for(int r = 0 ; r < N ; r ++) tmp[r] = map[r].clone(); // 한번에 녹이기 위해 => 맵 복사

        int cnt = 0;
        for(int r = 0 ; r < N ; r ++){
            for (int c = 0; c < N; c++) {
                cnt = 0;
                for(int d = 0 ; d < 4 ; d ++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if(!isValid(nr, nc) || map[nr][nc] == 0) continue;
                    cnt++;
                }
                if(cnt == 3 || cnt == 4) continue;
                if(tmp[r][c] >= 1){
                    tmp[r][c] --;
                    iceSum --;
                }
            }
        }
        map = tmp;
    }

    private static int bfs(int r, int c) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(r, c));
        int sum = 0;

        while(!q.isEmpty()){
            Node curr = q.poll();
            sum ++;

            for(int d = 0 ; d < 4 ; d ++){
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if(!isValid(nr, nc) || map[nr][nc] <= 0 || v[nr][nc]) continue;
                v[nr][nc] = true;
                q.offer(new Node(nr, nc));
            }
        }
        return sum;
    }

    private static boolean isValid(int nr, int nc) {
        return(nr>=0 && nr<N && nc>=0 && nc<N);
    }
}