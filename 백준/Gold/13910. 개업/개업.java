import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] arr, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M + 1];
        dp = new int[N + 1];

        Arrays.fill(dp, 1 << 30);

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    private static int bfs() {
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o1 - o2);

        dp[0] = 0;
        q.offer(0);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == N) return dp[N];

            // 1개 or 2개의 웍을 가지고 요리할 때
            for (int j = 0; j <= M; j++) {
                for (int k = j + 1; k <= M; k++) {
                    int nn = cur + arr[j] + arr[k];

                    // 넘치거나, 이전보다 큰 값이라면 패스
                    if (!isValid(nn) || dp[nn] <= dp[cur] + 1) continue;

                    dp[nn] = dp[cur] + 1;
                    q.offer(nn);
                }
            }
        }

        return -1;
    }

    private static boolean isValid(int nn) {
        return (nn >= 0 && nn <= N);
    }

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

    }
}