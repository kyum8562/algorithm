import java.io.*;
import java.util.*;
public class Main {
    static int R, C, H, ans;
    static int[][] map;
    static boolean finish = false;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H+1][C+1];

        for(int i = 0 ; i < R ; i ++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 1;
            map[r][c+1] = 2;
        }

        // 사다리를 최대한 놓을 수 있는 3개까지 돌림
        for(int i = 0 ; i <= 3 ; i ++){
            ans = i;
            dfs(1, 0);
            if(finish) break;
        }

        System.out.println(finish ? ans : -1);
    }

    private static void dfs(int r, int depth) {
        if(finish) return;

        if(depth == ans){
            if(check()) finish = true;
            return;
        }

        for (int i = r; i <= H; i++) {
            for (int j = 1; j < C; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
                    dfs(i, depth + 1);
                    map[i][j] = map[i][j + 1] = 0;
                }
            }
        }
    }

    private static boolean check() {
        for(int i = 1 ; i <= C ; i ++){
            int r = 1;
            int c = i;
            for(int j = 0 ; j < H ; j ++){
                if(map[r][c] == 1) c++;
                else if(map[r][c] == 2) c--;
                r++;
            }
            if(c != i) return false;
        }
        return true;
    }

}