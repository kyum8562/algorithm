import java.io.*;
import java.util.*;

public class Main {
    static int ans;
    static int[][] map, map2;
    static boolean[] v;
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ans = Integer.MAX_VALUE;
        map = new int[3][3];
        map2 = new int[3][3];
        v = new boolean[10];

        for(int i = 0 ; i < 3 ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3 ; j ++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        perm(0, 0, 0);

        System.out.println(ans);
    }

    private static void perm(int r, int c, int cost) {
        if(c == 3){
            r ++;
            c = 0;
        }
        if(r == 3){
            if(isValid()) ans = Math.min(ans, cost);
            return;
        }

        for(int i = 1 ; i <= 9 ; i ++){
            if(v[i]) continue;
            map2[r][c] = i;
            v[i] = true;
            perm(r, c+1, cost + Math.abs(map[r][c] - i));
            v[i] = false;
        }
    }

    private static boolean isValid() {
        // 각 행, 열, 대각선의 합이 15가 되어야 함

        // 대각선 체크
        if(map2[0][0] + map2[1][1] + map2[2][2] != 15) return false;
        if(map2[0][2] + map2[1][1] + map2[2][0] != 15) return false;
        // 행 체크
        for(int i = 0 ; i < 3 ; i ++)
            if(map2[i][0] + map2[i][1] + map2[i][2] != 15) return false;
        // 열 체크
        for(int i = 0 ; i < 3 ; i ++)
            if(map2[0][i] + map2[1][i] + map2[2][i] != 15) return false;

        return true;
    }
}