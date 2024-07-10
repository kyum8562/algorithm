import java.io.*;
import java.util.*;

public class Main {
    static int N, T;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        list = new ArrayList[T + 1];
        for (int i = 0; i <= T; i++)
            list[i] = new ArrayList<>();

        boolean isGame = false;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (c == T) isGame = true;

            list[c].add(r);
        }

        if (!isGame) System.out.print(-1);
        else System.out.print(bfs());
    }

    private static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0));

        List<Integer> next;
        int cnt = 0;

        while (!q.isEmpty()) {
            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {
                Node cur = q.poll();
                int r = cur.r;
                int c = cur.c;

                if (c == T) return cnt;

                for (int nc = c - 2; nc <= c + 2; nc++) {
                    if (!isValid(nc)) continue;

                    next = list[nc];

                    for (int j = 0; j < next.size(); j++) {
                        int nr = next.get(j);
                        if (Math.abs(nr - r) > 2) continue;

                        next.remove(j);
                        q.add(new Node(nr, nc));
                        j--;
                    }
                }
            }

            cnt ++;
        }

        return -1;
    }

    private static boolean isValid(int nc) {
        return nc >= 0 && nc <= T;
    }

    static class Node{
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}