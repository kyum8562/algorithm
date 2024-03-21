import java.io.*;
import java.util.*;

class Main {
    static int R, C, ans;
    static int[][] arr;
    static boolean[][] v;
    static boolean[] alphaCheck;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphaCheck = new boolean[27];
        v = new boolean[R][C];
        arr = new int[R][C];

        for (int i = 0; i < R; i ++){
            String s = br.readLine();
            for(int j = 0 ; j < C ; j ++)
                arr[i][j] = s.charAt(j) - 'A';
        }

        ans = -(1 << 30);

        v[0][0] = true;
        alphaCheck[arr[0][0]] = true;

        dfs(0, 0, 1);

        System.out.print(ans);
    }

    private static void dfs(int r, int c, int cnt) {
        ans = Math.max(ans, cnt);

        for(int d = 0 ; d < 4 ; d ++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(!isValid(nr, nc) || v[nr][nc]) continue;
            if(alphaCheck[arr[nr][nc]]) continue;

            v[nr][nc] = true;
            alphaCheck[arr[nr][nc]] = true;

            dfs(nr, nc, cnt+1);

            v[nr][nc] = false;
            alphaCheck[arr[nr][nc]] = false;
        }
    }
    static boolean isValid(int nr, int nc){
        return (nr>=0 && nr<R && nc>=0 && nc<C);
    }

}