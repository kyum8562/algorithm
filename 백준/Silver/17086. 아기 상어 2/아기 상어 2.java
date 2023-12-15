import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans=0;
    static int[][] map, v;
    static List<int[]> list;
    static Queue<int[]> q = new ArrayDeque<>();
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        v = new int[N][M];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1)
                    q.offer(new int[]{i, j});
                else
                    v[i][j] = Integer.MAX_VALUE;
            }
        }

        marking();
        System.out.println(ans);
    }

    private static void marking() {
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for (int d = 0; d < 8; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (!isValid(nr, nc)) continue;
                if(v[nr][nc] > v[curr[0]][curr[1]] + 1){
                    v[nr][nc] = v[curr[0]][curr[1]] + 1;
                    ans = Math.max(ans, v[nr][nc]);
                    q.offer(new int[]{nr, nc});
                }

            }
        }
    }

    private static boolean isValid(int nr, int nc) {
        return(nr>=0 && nr<N && nc>=0 && nc<M);
    }
}