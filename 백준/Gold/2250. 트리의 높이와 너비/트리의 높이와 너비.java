import java.io.*;
import java.util.*;

public class Main {
    static int ans, maxDepth, colIdx;
    static Node[] node;
    static int[] size, parents, depthMin, depthMax;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ans = 0;
        maxDepth = 0;
        colIdx = 1;

        node = new Node[N + 1];
        size = new int[N + 1];
        parents = new int[N + 1];
        depthMin = new int[N + 1];
        depthMax = new int[N + 1];

        Arrays.fill(parents, -1);

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            node[n] = new Node(a, b);

            if(a != -1) parents[a] = n;
            if(b != -1) parents[b] = n;

            depthMin[i] = 1 << 30;
        }

        // 루트 노드를 찾아서(-1) 재귀 실행
        for(int i = 1 ; i <= N ; i ++){
            if(parents[i] != -1) continue;
            dfs(i, 1);
            break;
        }

        int ansDepth = 1;
        int ansWidth = depthMax[1] - depthMin[1];
        for(int i = 2 ; i <= maxDepth ; i ++){
            int width = depthMax[i] - depthMin[i];
            if(width > ansWidth){
                ansWidth = width;
                ansDepth = i;
            }
        }

        // 마지막에 뎁스 + 1해줘야 함(0부터 시작해서)
        System.out.print(ansDepth + " " + (ansWidth+1));
    }

    private static void dfs(int curr, int depth) {
        if (curr == -1) return;

        Node cur = node[curr];

        maxDepth = Math.max(maxDepth, depth);

        dfs(cur.left, depth + 1);

        depthMin[depth] = Math.min(depthMin[depth], colIdx);
        depthMax[depth] = colIdx ++;

        dfs(cur.right, depth + 1);
    }

    static class Node {
        int left, right;
        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}