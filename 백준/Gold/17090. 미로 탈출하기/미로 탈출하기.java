import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] arr, dp;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dp = new int[N][M];
        v = new boolean[N][M];

        for(int i = 0 ; i < N ; i ++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++)
                arr[i][j] = getDir(s.charAt(j));
        }

        int cnt = 0;
        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < M ; j ++){

                // 이미 결정이 되었다면
                if(dp[i][j] == 1) cnt ++;
                // 결정되지 않았다면
                else if(dp[i][j] == 0 && !v[i][j]){
                    cnt += recur(i, j) == 1 ? 1 : 0;
                }
            }
        }

        System.out.println(cnt);
    }

    private static int recur(int r, int c) {
        if(!isValid(r, c)) return 1; // 성공

        if(dp[r][c] != 0) return dp[r][c];

        if(v[r][c]) return 2; // 실패
        else v[r][c] = true;


        int d = arr[r][c];

        int nr = r + dr[d];
        int nc = c + dc[d];

        dp[r][c] = recur(nr, nc);
        v[r][c] = false;

        return dp[r][c];
    }

    private static int getDir(char c) {
        if(c == 'U') return 0;
        else if(c == 'R') return 1;
        else if(c == 'D') return 2;
        else return 3;
    }

    private static boolean isValid(int r, int c) {
        return (r>=0 && r<N && c>=0 && c<M);
    }
}