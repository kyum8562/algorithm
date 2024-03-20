import java.io.*;
import java.util.*;

class Main {
    static int cnt, N;
    static boolean[][] v;
    static char[][] arr;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        v = new boolean[N][N];

        for(int i = 0 ; i < N ; i ++)
            arr[i] = br.readLine().toCharArray();

        int ans = 0; // 연결 요소의 개수
        List<Integer> list = new ArrayList<>(); // 연결 요소 별 개수 담는 곳

        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < N ; j ++){
                if(v[i][j] || arr[i][j] == '0') continue;

                cnt = 0;
                ans ++;

                dfs(i, j);

                list.add(cnt);
            }
        }

        Collections.sort(list);

        sb.append(ans).append("\n");
        for(int cur: list)
            sb.append(cur).append("\n");

        System.out.print(sb);
    }

    private static void dfs(int r, int c) {
        v[r][c] = true;
        cnt ++;

        for(int d = 0 ; d < 4 ; d ++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(!isValid(nr, nc) || v[nr][nc] || arr[nr][nc] == '0') continue;

            dfs(nr, nc);
        }
    }

    private static boolean isValid(int nr, int nc) {
        return (nr>=0 && nr<N && nc>=0 && nc<N);
    }
}