import java.io.*;
import java.util.*;
public class Main {
    static int R, C, K, ans = 0;
    static char[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        boolean[][] v = new boolean[R][C];
        map = new char[R][C];
        for(int i = 0 ; i < R ; i ++){
            String s = br.readLine();
            for(int j = 0 ; j < C ; j ++){
                map[i][j] = s.charAt(j);
            }
        }
        v[R-1][0] = true;
        // 시작
        dfs(R-1, 0, 1, v);
        System.out.println(ans);
    }

    private static void dfs(int r, int c, int cnt, boolean[][] v) {

        for(int d = 0 ; d < 4 ; d ++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(!isValid(nr, nc) || v[nr][nc] || map[nr][nc] == 'T') continue;
            if(nr == 0 && nc == C-1 && cnt == K-1) ans++;

//            boolean[][] tmp = new boolean[R][C];
//            for(int i = 0 ; i < R ; i ++){
//                tmp[i] = v[i].clone();
//            }
            v[nr][nc] = true;
            dfs(nr, nc, cnt +1, v);
            v[nr][nc] = false;
        }
    }
    static boolean isValid(int nr, int nc){
        return(nr>=0 && nr<R && nc>=0 && nc<C);
    }
}