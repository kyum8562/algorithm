import java.io.*;
import java.util.*;

/**
 * 맵을 매번 순회하면서(50,000) 가기.. ? x(시간 터짐)
 * 방문처리, 2차원 배열에 마킹하기 ? x(공간 터짐)
 * 맵, o
 */

public class Main {
    static int N, T, ans;
//    static Queue<Node> q = new ArrayDeque<>();
    static PriorityQueue<Node> q = new PriorityQueue<>();
//    static Map<Integer, Boolean> map = new LinkedHashMap<>();
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
        ans = 1 << 30;

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(c == T) isGame = true;

            list[c].add(r);
        }

        if(!isGame)
            System.out.println(-1);
        else
            bfs();

        System.out.println(ans == 1 << 30 ? -1 : ans);
    }

    private static void bfs() {
        q.offer(new Node(0, 0, 0));

        while(!q.isEmpty()){
            Node cur = q.poll();
            int r = cur.r;
            int c = cur.c;

            if(c == T){
                ans = cur.d;
                return;
            }

            // 방문 처리
//            int val = cur.r*10 + cur.c;
//            map.put(val, true);

            List<Integer> tmp;

            for(int nc = c - 2 ; nc <= c + 2 ; nc ++) {

                if(!isValid(nc)) continue;

                tmp = new ArrayList<>();

//                for(int nr: list[nc]){
//                    if(Math.abs(nr - r) > 2) continue;
//
//                    list[nc].remove(nr);
//                    q.offer(new Node(nr, nc, cur.d + 1));
////                    tmp.add(nr);
//
//                }

                for (int j = 0; j < list[nc].size(); j++) {
                    int nr = list[nc].get(j);
//                    if (r + 2 < nr) break;
//                    else if (r - 2 > nr) continue;
                    if(Math.abs(nr - r) > 2) continue;


                    list[nc].remove(j);
                    q.add(new Node(nr, nc, cur.d+1));
                    j--;
                }

//                for(int val: tmp) list[nc].remove(val);
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