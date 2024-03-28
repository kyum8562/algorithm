import java.io.*;
import java.util.*;

class Main {
    static int S, E;
    static boolean[] v;
    static int[] prev;
    static int[] dd = {-1, 1, 2};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        v = new boolean[100002];
        prev = new int[100002];

        bfs();

        int idx = E;
        Stack<Integer> stack = new Stack<>();
        while(idx != -1){
            stack.push(idx);
            idx = prev[idx];
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();

        int cnt = 0;

        v[S] = true;
        prev[S] = -1;
        q.offer(S);

        while (!q.isEmpty()) {
            int qSize = q.size();

            for (int i = 0 ; i < qSize ; i++) {
                int cur = q.poll();

                if (cur == E) {
                    sb.append(cnt).append("\n");
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
                    prev[nn] = cur;
                    q.offer(nn);
                }
            }

            cnt++;
        }
    }
}