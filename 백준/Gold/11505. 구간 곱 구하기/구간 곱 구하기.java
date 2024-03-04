import java.io.*;
import java.util.*;

class Main {
    static final int MAXVAL = 1_000_000_007;
    static long[] map, tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        map = new long[N+1];
        tree = new long[N*4];

        for(int i = 1 ; i <= N ; i ++)
            map[i] = Long.parseLong(br.readLine());

        init(1, N, 1);

        for(int i = 0 ; i < K ; i ++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            // 값 업데이트
            if(type == 1){
                map[A] = B;
                update(1, N, 1, A, B);
            }
            // 구간 곱 구하기
            else{
                sb.append(multiple(1, N, 1, A, B)).append("\n");
            }
        }
        System.out.print(sb);
    }
    private static long init(int start, int end, int node) {
        if(start == end)
            return tree[node] = map[start];

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node*2) * init(mid+1, end, node*2+1) % MAXVAL;
    }
    private static long update(int start, int end, int node, int tgtIdx, long newVal) {
        if(tgtIdx > end || start > tgtIdx) return tree[node];

        if(start == end) return tree[node] = newVal;

        int mid = (start + end) / 2 ;
        return tree[node] = update(start, mid, node*2, tgtIdx, newVal) * update(mid+1, end, node*2+1, tgtIdx, newVal) % MAXVAL;
    }
    private static long multiple(int start, int end, int node, int left, long right) {
        if(left > end || right < start) return 1;
        if(start >= left && right >= end) return tree[node];

        int mid = (start + end) / 2;
        return multiple(start, mid, node*2, left, right) * multiple(mid+1, end, node*2+1, left, right) % MAXVAL;
    }
}