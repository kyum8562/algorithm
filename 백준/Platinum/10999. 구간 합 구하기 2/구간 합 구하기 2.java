import java.io.*;
import java.util.*;

class Main {
    static int N;
    static long[] map, tree, lazy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        map = new long[N+1];
        for(int i = 0 ; i < N ; i ++)
            map[i] = Long.parseLong(br.readLine());

        tree = new long[N*4];
        lazy = new long[N*4];

        init(0, N-1, 1);

        for(int i = 0 ; i < K ; i ++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken())-1;
            int B = Integer.parseInt(st.nextToken())-1;

            // 구간 업데이트
            if(type == 1){
                long newVal = Long.parseLong(st.nextToken());
                update(0, N-1, 1, A, B, newVal);
            }
            else
                sb.append(sum(0, N-1, 1, A, B)).append("\n");
        }

        System.out.println(sb);
    }
    private static long init(int start, int end, int node) {
        if(start == end) return tree[node] = map[start];

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
    }
    private static void propagate(int start, int end, int node) {
        // 레이지에 해당하지 않는다면
        if(lazy[node] == 0) return;
        // 리프노드가 아니라면
        if(start != end){
            lazy[node*2] += lazy[node];
            lazy[node*2+1] += lazy[node];
        }
        tree[node] += lazy[node] * (end - start + 1);
        lazy[node] = 0;
    }
    private static void update(int start, int end, int node, int A, int B, long newVal) {
        propagate(start, end, node);
        if(A > end || B < start) return;
        if(start >= A && B >= end){
            lazy[node] = newVal;
            propagate(start, end, node);
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, node*2, A, B, newVal);
        update(mid+1, end, node*2+1, A, B, newVal);

        tree[node] = tree[node*2] + tree[node*2+1];
    }
    private static long sum(int start, int end, int node, int A, int B) {
        propagate(start, end, node);
        if(A > end || B < start) return 0;
        if(start >= A && B >= end) return tree[node];

        int mid = (start + end) / 2;
        return sum(start, mid, node*2, A, B) + sum(mid+1, end, node*2+1, A, B);
    }
}