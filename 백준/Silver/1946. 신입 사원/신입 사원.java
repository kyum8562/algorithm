import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Node[] arr;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            arr = new Node[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[i] = new Node(a, b);
            }

            Arrays.sort(arr);

            int val = arr[0].b;
            int ans = 1;

            for (int i = 1; i < N; i++){
                if (val > arr[i].b) {
                    val = arr[i].b;
                    ans++;
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {
        int a, b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Node o) {
            return this.a - o.a;
        }
    }
}