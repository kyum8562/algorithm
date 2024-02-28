import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] map, tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        map = new long[N + 1];
        tree = new long[N*4];

        for (int i = 1; i <= N; i++)
            map[i] = Long.parseLong(br.readLine());

        setSegmentTree(1, N, 1);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            // 특정 값 update
            if(type == 1){
                long newVal = b - map[a];
                map[a] = b;
                setUpdate(1, N, 1, a, newVal);
            }
            // 구간 합 구하기
            else
                sb.append(getSum(1, N, 1, a, (int) b)).append("\n");

        }
        System.out.println(sb);
    }

    private static long getSum(int start, int end, int node, int left, int right) {
        // 범위 밖에 있을 경우
        if(left > end || right < start) return 0;

        // 범위 안에 있을 경우
        if(start >= left && right >= end)
            return tree[node];

        int mid = (start + end) / 2;
        return getSum(start, mid, node*2, left, right) + getSum(mid+1, end, node*2+1, left, right);
    }

    private static void setUpdate(int start, int end, int node, int targetIdx, long newVal) {
        // 범위 밖에 있을 경우
        if(targetIdx > end || targetIdx < start) return;

        // 범위 안에 있으면 아래로 내려가며 다른 노드도 갱신
        tree[node] += newVal;

        if(start == end) return;

        int mid = (start + end) / 2;
        setUpdate(start, mid, node*2, targetIdx, newVal);
        setUpdate(mid+1, end, node*2+1, targetIdx, newVal);
    }

    private static long setSegmentTree(int start, int end, int node) {
        if(start == end)
            return tree[node] = map[start];

        int mid = (start + end) / 2;
        return tree[node] = setSegmentTree(start, mid, node*2) + setSegmentTree(mid+1, end, node*2+1);
    }
}