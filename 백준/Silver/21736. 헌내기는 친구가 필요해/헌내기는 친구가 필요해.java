import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans = 0;
    static char[][] map;
    static boolean[][] v;
    static List<Integer>[] list;
    static StringBuilder sb = new StringBuilder();
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int sr = 0, sc = 0;
        map = new char[N][M];
        v = new boolean[N][M];
        for(int i = 0 ; i < N ; i ++){
            String s = br.readLine();
            for(int j = 0 ; j < M ; j ++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'I'){
                    sr = i;
                    sc = j;
                }
            }
        }

        dfs(new int[]{sr, sc});
        System.out.println(ans == 0 ? "TT" : ans);
    }

    private static void dfs(int[] curr) {
        for(int d = 0 ; d < 4 ; d ++){
            int nr = curr[0] + dr[d];
            int nc = curr[1] + dc[d];

            if(!isValid(nr, nc) || v[nr][nc] || map[nr][nc] == 'X') continue;
            v[nr][nc] = true;
            if(map[nr][nc] == 'P') ans ++;
            dfs(new int[]{nr, nc});
        }
    }
    static boolean isValid(int nr, int nc){
        return (nr>=0 && nr<N && nc>=0 && nc<M);
    }
}