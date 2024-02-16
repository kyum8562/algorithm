import java.io.*;
import java.util.*;

public class Main {
    static int R, C, ans, listSize;
    static int[][] map, map2;
    static List<Node> cctvList = new ArrayList<>();
    static Stack<Integer> stack = new Stack<>();
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        cctvList = new ArrayList<>();
        ans = Integer.MAX_VALUE;

        for(int i = 0 ; i < R ; i ++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                if(tmp == 0 || tmp == 6) continue;
                cctvList.add(new Node(i, j, tmp));
            }
        }

        listSize = cctvList.size();

        perm(0);
        System.out.println(ans);
    }

    private static void perm(int depth) {
        if(depth == listSize){
            action();
            return;
        }

        for(int d = 0 ; d < 4 ; d ++){
            stack.push(d);
            perm(depth+1);
            stack.pop();
        }
    }

    private static void action() {
        // 마킹용 map(map 복사)
        map2 = new int[R][C];
        mapClone();

        // 넓히기
        for(int i = 0 ; i < listSize ; i ++){
            int r = cctvList.get(i).r;
            int c = cctvList.get(i).c;
            int d = stack.get(i);
            int[] map3;

            // 현재 cctv가 갈 수 있는 방향 지정
            if(map[r][c] == 1)
                map3 = new int[] {d};
            else if(map[r][c] == 2)
                map3 = new int[] {d, d+2};
            else if(map[r][c] == 3)
                map3 = new int[] {d, d+1};
            else if(map[r][c] == 4)
                map3 = new int[] {d, d+1, d+2};
            else
                map3 = new int[] {d, d+1, d+2, d+3};
            
            // 갈 수 있는 방향으로 뻗을 수 있을 때 까지 뻗기
            for(int idx: map3){
                int nd = (idx) % 4;
                int nr = r + dr[nd];
                int nc = c + dc[nd];
                
                while(isValid(nr, nc) && map[nr][nc] != 6){
                    map2[nr][nc] = 7;
                    nr += dr[nd];
                    nc += dc[nd];
                }
            }
        }

        // cctv개수 카운팅
        int cnt = 0;
        for(int i = 0 ; i < R ; i ++){
            for(int j = 0 ; j < C ; j ++)
                if(map2[i][j] == 0) cnt ++;
        }

        ans = Math.min(ans, cnt);
    }

    private static boolean isValid(int nr, int nc) {
        return (nr>=0 && nr<R && nc>=0 && nc<C);
    }

    private static void mapClone() {
        for(int i = 0 ; i < R ; i ++){
            for(int j = 0 ; j < C ; j ++)
                map2[i][j] = map[i][j];
        }
    }

    static class Node{
        int r, c, v;
        public Node(int r, int c, int v){
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }
}