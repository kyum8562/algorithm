import java.io.*;
import java.util.*;

class Main {
    static int R, C, ans;
    static char[][] arr;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        v = new boolean[R][C];

        for(int i = 0 ; i < R ; i ++)
            arr[i] = br.readLine().toCharArray();

        ans = 0;

        for(int i = 0 ; i < R ; i ++)
            dfs(i, 0);

        System.out.print(ans);
    }

    private static boolean dfs(int r, int c) {
        arr[r][c] = 'x';

        if(c == C-1){
            ans ++;
            return true;
        }

        for(int d = 0 ; d < 3 ; d ++){
            int nr = r + dr[d];
            int nc = c + 1;

            if(!isValid(nr, nc) || arr[nr][nc] == 'x') continue;

            if(dfs(nr, nc)) return true;
        }

        return false;
    }

    private static boolean isValid(int nr, int nc) {
        return (nr>=0 && nr<R && nc>=0 && nc<C);
    }

}