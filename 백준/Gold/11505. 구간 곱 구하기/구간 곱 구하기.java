import java.io.*;
import java.util.*;

public class Main {
    static final int DIVIDE_NUM = 1_000_000_007;
    static int N, Q;
    static long[] tree;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        tree = new long[N*4];

        for(int i = 1 ; i <= N ; i ++)
            arr[i] = Integer.parseInt(br.readLine());

        init(1, N, 1);

        for(int i = 0 ; i < Q ; i ++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if(type == 1){
                arr[A] = B;
                update(1, N, 1, A, B);
            }
            else
                sb.append(multiple(1, N, 1, A, (int)B)).append("\n");
        }
        System.out.print(sb);
    }
    private static long init(int start, int end, int node) {
        if(start == end)
            return tree[node] = arr[start];

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node*2) * init(mid+1, end, node*2+1) % DIVIDE_NUM;
    }
    private static long update(int start, int end, int node, int tgtIdx, long newVal) {
        if(tgtIdx > end || tgtIdx < start) return tree[node];

        if(start == end) return tree[node] = newVal;

        int mid = (start + end) / 2;
        return tree[node] = update(start, mid, node*2, tgtIdx, newVal) *
                            update(mid+1, end, node*2+1, tgtIdx, newVal) % DIVIDE_NUM;
    }
    private static long multiple(int start, int end, int node, int left, int right) {
        if(left > end || right < start) return 1;
        if(start >= left && right >= end) return tree[node];

        int mid = (start + end) / 2;
        return multiple(start, mid, node*2, left, right) * multiple(mid+1, end, node*2+1, left, right) % DIVIDE_NUM;
    }
}