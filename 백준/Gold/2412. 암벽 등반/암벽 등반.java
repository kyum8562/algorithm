import java.io.*;
import java.util.*;

public class Main {
    static int N, T, ans;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        list = new ArrayList[T+1];
        for(int i = 0 ; i <= T ; i ++)
            list[i] = new ArrayList<>();

        boolean isGame = false;

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(c == T) isGame = true;

            list[c].add(r);
        }

        if(!isGame) System.out.print(-1);
        else bfs();

        System.out.print(ans == 0 ? -1 : ans);
    }

    private static void bfs() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(0, 0, 0));

        List<Integer> next;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int r = cur.r;
            int c = cur.c;

            if(c == T){
                ans = cur.d;
                return;
            }

            for(int nc = c - 2 ; nc <= c + 2 ; nc ++) {
                if(!isValid(nc)) continue;

                next = list[nc];

                for (int j = 0; j < next.size(); j++) {
                    int nr = next.get(j);
                    if(Math.abs(nr - r) > 2) continue;

                    next.remove(j);
                    q.add(new Node(nr, nc, cur.d+1));
                    j--;
                }

            }
        }
    }

    private static boolean isValid(int nc) {
        return nc >= 0 && nc <= T;
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