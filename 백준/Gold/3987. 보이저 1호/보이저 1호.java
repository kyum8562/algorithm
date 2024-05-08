import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1 << 30;
    static int R, C;
    static char[][] arr;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
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
        int dir = 4;

        for(int i = 0 ; i < 4 ; i ++){
            int res = bfs(sr, sc, i);

            if(res == INF){
                max = INF;
                dir = i;
                break;
            }

            if(res > max){
                max = res;
                dir = i;
            }
            else if(res == max){
                if(dir > i) dir = i;
            }
        }

        sb.append(parseResD(dir)).append("\n");
        sb.append(max == INF ? "Voyager" : max).append("\n");

        System.out.print(sb);
    }

    private static int bfs(int sr, int sc, int sd) {
        Queue<Node> q = new ArrayDeque<>();

        int max = 1;
        q.offer(new Node(sr, sc, sd, 1));

        while(!q.isEmpty()){
            Node cur = q.poll();

            // 정답 갱신
            max = Math.max(max, cur.t);

            // 무한루프 케이스 처리
            if(cur.t >= R*C*2) return INF;

            // 현재 인덱스가 '.'일 때
            int nr = cur.r + dr[cur.d];
            int nc = cur.c + dc[cur.d];

            if(!isValid(nr, nc) || arr[nr][nc] == 'C') break;

            q.offer(new Node(nr, nc, arr[nr][nc] == '.' ? cur.d : parsingD(cur.d, arr[nr][nc]), cur.t+1));
        }

        return max;
    }

    private static int parsingD(int d, char c) {
        if(c == '\\'){
            if(d == 0) return 3;
            else if(d == 1) return 2;
            else if(d == 2) return 1;
            else return 0;
        }
        else{
            if(d == 0) return 1; // 북으로 향하면 동으로 변경
            else if(d == 1) return 0;
            else if(d == 2) return 3;
            else return 2;
        }
    }

    private static char parseResD(int c) {
        if(c == 0) return 'U';
        else if(c == 1) return 'R';
        else if(c == 2) return 'D';
        else return 'L';
    }

    private static boolean isValid(int nr, int nc) {
        return (nr>=0 && nr<R && nc>=0 && nc<C);
    }

    static class Node{
        int r, c, d, t;
        public Node(int r, int c, int d, int t){
            this.r = r;
            this.c = c;
            this.d = d;
            this.t = t;
        }
    }
}