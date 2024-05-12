import java.io.*;
import java.util.*;

public class Main {
    static int ans, sr, sc;
    static boolean[][] v, v2;
    static char[][] arr;
    static Queue<int[]> q = new ArrayDeque<>();
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        ans = 0;
        arr = new char[5][5];
        v = new boolean[5][5];

        for(int i = 0 ; i < 5 ; i ++){
            String s = br.readLine();
            for(int j = 0 ; j < 5 ; j ++)
                arr[i][j] = s.charAt(j);
        }

        comb(0, 0, 0);

        System.out.println(ans);
    }

    private static void comb(int depth, int start, int cnt) {
        // 임도연파가 4명이라면 pass
        if(cnt == 4) return;
        // 7명이 구성되었다면(임도연파 3명이하)
        if(depth == 7){
            // bfs 탐색을 통해서 연결되었는지 확인
            if(bfs(sr, sc)) ans++;
            return;
        }

        for(int i = start ; i <= 24 ; i ++){
            int r = i / 5;
            int c = i % 5;

            if(depth == 0){
                sr = r;
                sc = c;
            }

            v[r][c] = true;

            if(arr[r][c] == 'Y')
                comb(depth+1, i+1, cnt+1);
            else
                comb(depth+1, i+1, cnt);

            v[r][c] = false;

        }
    }

    private static boolean bfs(int i, int j) {
        q = new ArrayDeque<>();
        v2 = new boolean[5][5];

        v2[i][j] = true;
        q.offer(new int[] {i, j});
        int res = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int d = 0 ; d < 4 ; d ++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(!isValid(nr, nc) || v2[nr][nc] || !v[nr][nc]) continue;

                res ++;
                v2[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }

        return res == 7;
    }

    private static boolean isValid(int nr, int nc) {
        return (nr>=0 && nr<5 && nc>=0 && nc<5);
    }
}