import java.io.*;
import java.util.*;
class Main {
    static int N, Q;
    static long[] map, tree;
    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        map = new long[N+1];
        tree = new long[N*4];

        for (int i = 1; i <= N; i++)
            map[i] = Long.parseLong(br.readLine());

        // 세그먼트 트리 생성
        init(1, N, 1);

        for(int i = 0 ; i < Q ; i ++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            // 수열 업데이트
            if(type == 1){
                long newValue = B - map[A];
                map[A] = B;
                update(1, N, 1, A, newValue);
            }
            // 구간 합 구하기
            else{
                sb.append(sum(1, N, 1, A, (int)B)).append("\n");
            }
        }
        System.out.println(sb);
    }
    private static long init(int start, int end, int node) {
        if(start == end) return tree[node] = map[start];

        int mid = (start+end) / 2;
        return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
    }
    private static void update(int start, int end, int node, int tgtIdx, long newValue) {
        if(tgtIdx > end || tgtIdx < start) return;

        tree[node] += newValue;

        if(start == end) return;

        int mid = (start+end) / 2;
        update(start, mid, node*2, tgtIdx, newValue);
        update(mid+1, end, node*2+1, tgtIdx, newValue);
    }

    private static long sum(int start, int end, int node, int left, int right) {
        if(left > end || right < start) return 0;
        if(start >= left && right >= end) return tree[node];

        int mid = (start+end) / 2;
        return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
    }
}