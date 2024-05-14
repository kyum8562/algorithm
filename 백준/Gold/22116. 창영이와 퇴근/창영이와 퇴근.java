import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[][] v;
    static List<Integer>[] list;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 노드 수

        arr = new int[N][N];
        v = new boolean[N][N];

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j ++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    private static long bfs() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(0, 0, 0));
        int res = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();

            v[cur.r][cur.c] = true;
            res = Math.max(res, cur.d);

            if(cur.r == N-1 && cur.c == N-1) break;

            for(int d = 0 ; d < 4 ; d ++){
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if(!isValid(nr, nc) || v[nr][nc]) continue;

                q.offer(new Node(nr, nc, Math.abs(arr[nr][nc] - arr[cur.r][cur.c])));
            }
        }

        return res;
    }

    private static boolean isValid(int nr, int nc) {
        return (nr>=0 && nr<N && nc>=0 && nc<N);
    }
    static class Node implements Comparable<Node>{
        int r, c, d;
        public Node(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }

        @Override
        public int compareTo(Node o){
            return this.d - o.d;
        }
    }
}