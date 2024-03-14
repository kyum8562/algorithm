import java.io.*;
import java.util.*;

public class Main {
    static int N, Q;
    static long[] arr, tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        tree = new long[N*4];

        for(int i = 1 ; i <= N ; i ++)
            arr[i] = Long.parseLong(br.readLine());

        init(1, N, 1);

        for(int i = 0 ; i < Q ; i ++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            if(type == 1){
                long newVal = B - arr[A];
                arr[A] = B;
                update(1, N, 1, A, newVal);
            }
            else
                sb.append(sum(1, N, 1, A, (int)B)).append("\n");
        }
        System.out.print(sb);
    }
    private static long init(int start, int end, int node) {
        if(start == end)
            return tree[node] = arr[start];

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
    }
    private static void update(int start, int end, int node, int tgtIdx, long newVal) {
        if(tgtIdx > end || tgtIdx < start) return;

        tree[node] += newVal;

        if(start == end) return;

        int mid = (start + end) / 2;
        update(start, mid, node*2, tgtIdx, newVal);
        update(mid+1, end, node*2+1, tgtIdx, newVal);
    }
    private static long sum(int start, int end, int node, int left, int right) {
        if(left > end || right < start) return 0;
        if(start >= left && right >= end) return tree[node];

        int mid = (start + end) / 2;
        return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
    }
}