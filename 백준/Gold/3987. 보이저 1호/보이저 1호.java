import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1 << 30;
    static int R, C;
    static char[][] arr;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static char[] dirArr = {'U', 'R', 'D', 'L'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];

        for(int i = 0 ; i < R ; i ++){
            String s = br.readLine();
            for(int j = 0 ; j < C ; j ++)
                arr[i][j] = s.charAt(j);
        }

        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken())-1;
        int sc = Integer.parseInt(st.nextToken())-1;

        int max = 1;
        int dir = -1;

        for(int i = 0 ; i < 4 ; i ++){
            int res = play(sr, sc, i);

            // 무한루프 케이스
            if(res == INF){
                max = INF;
                dir = i;
                break;
            }

            // 갱신
            if(res > max){
                max = res;
                dir = i;
            }
        }

        sb.append(dirArr[dir]).append("\n");
        sb.append(max == INF ? "Voyager" : max).append("\n");

        System.out.print(sb);
    }

    private static int play(int r, int c, int d) {
        int time = 1;

        while(true){

            int nr = r + dr[d];
            int nc = c + dc[d];

            // 유효성 및 블랙홀 여부 체크
            if(!isValid(nr, nc) || arr[nr][nc] == 'C') break;

            // 무한루프 케이스 처리
            if(time >= R*C*2) return INF;

            // r,c 갱신
            r = nr;
            c = nc;

            // '/' or '\'일 때
            if(arr[nr][nc] != '.')
                d = parsingD(d, arr[nr][nc]);

            time ++;
        }

        return time;
    }

    private static int parsingD(int d, char c) {
        if(c == '\\')
            return 3 - d;
        else{
            if(d >= 0 && d <= 1) return 1 - d;
            else return 5 - d;
        }
    }

    private static boolean isValid(int nr, int nc) {
        return (nr>=0 && nr<R && nc>=0 && nc<C);
    }
}