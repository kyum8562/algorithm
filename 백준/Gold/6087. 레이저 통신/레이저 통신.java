import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static List<Node> list;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        list = new ArrayList<>();
        for(int i = 0 ; i < R ; i ++){
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'C')
                    list.add(new Node(i, j));
            }
        }
        dijkstra();
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o1.usingM - o2.usingM));
        boolean[][][] v = new boolean[R][C][4];

        for(int i = 0 ; i < 4 ; i ++)
            pq.offer(new Node(list.get(0).r, list.get(0).c, i, 0));

        int endR = list.get(1).r;
        int endC = list.get(1).c;
        while(!pq.isEmpty()){
            Node curr = pq.poll();

            v[curr.r][curr.c][curr.d] = true;

            if(curr.r == endR && curr.c == endC){
                System.out.println(curr.usingM);
                return;
            }

            int nr = curr.r + dr[curr.d];
            int nc = curr.c + dc[curr.d];

            if(!isValid(nr, nc) || v[nr][nc][curr.d] || map[nr][nc] == '*') continue;

            pq.offer(new Node(nr, nc, (curr.d+1)%4, curr.usingM+1));
            pq.offer(new Node(nr, nc, (curr.d+3)%4, curr.usingM+1));
            pq.offer(new Node(nr, nc, curr.d, curr.usingM));
        }
    }

    static boolean isValid(int nr, int nc) {
        return(nr>=0 && nr<R && nc>=0 && nc<C);
    }

    static class Node{
        int r, c, d, usingM;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
        public Node(int r, int c, int d, int usingM){
            this.r = r;
            this.c = c;
            this.d = d;
            this.usingM = usingM;
        }
    }
}