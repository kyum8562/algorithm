import java.io.*;
import java.util.*;

class Main {
    static int S, E;
    static boolean[] v;
    static int[] dd = {-1, 1, 2};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        v = new boolean[100002];

        bfs();
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();

        int cnt = 0;

        v[S] = true;
        q.offer(S);

        while (!q.isEmpty()) {
            int qSize = q.size();

            for (int i = 0 ; i < qSize ; i++) {
                int cur = q.poll();

                if (cur == E) {
                    System.out.println(cnt);
                    return;
                }

                for (int d = 0 ; d < 3 ; d ++) {
                    int nn;

                    if (d == 2)
                        nn = cur * dd[d];
                    else
                        nn = cur + dd[d];

                    if (nn > 100000 || nn < 0 || v[nn]) continue;

                    v[nn] = true;
                    q.offer(nn);
                }
            }

            cnt++;
        }
    }
}