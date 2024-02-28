import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] map;
    static Point tree[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        map = new int[N + 1];
        for (int i = 1; i <= N; i++)
            map[i] = Integer.parseInt(br.readLine());

        int size = getTreeSize();
        tree = new Point[size];

        setSegmentTree(1, N, 1);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // [a, b) 최대 최소 구하기
            Point res = getMaxAndMin(1, N, 1, a, b);
            sb.append(res.y).append(" ").append(res.x).append("\n");
        }
        System.out.println(sb);
    }

//    private static Point setUpdate(int start, int end, int idx, int targetIdx, int newValue) {
//        if (targetIdx < start || targetIdx > end) {
//            return tree[idx];
//        }
//
//        // 대상 인덱스가 현재 세그먼트 범위를 벗어나면 현재 세그먼트 트리 노드를 반환
//        if (start == end) {
//            map[targetIdx] = newValue;
//            return tree[idx] = new Point(newValue, newValue);
//        }
//
//        int mid = (start + end) / 2;
//        // 대상 인덱스에 따라 왼쪽 또는 오른쪽 서브트리를 재귀적으로 업데이트
//        if (targetIdx <= mid) {
//            Point left = setUpdate(start, mid, idx * 2, targetIdx, newValue);
//            Point right = tree[idx * 2 + 1];
//            return tree[idx] = new Point(Math.max(left.x, right.x), Math.min(left.y, right.y));
//        } else {
//            Point left = tree[idx * 2];
//            Point right = setUpdate(mid + 1, end, idx * 2 + 1, targetIdx, newValue);
//            return tree[idx] = new Point(Math.max(left.x, right.x), Math.min(left.y, right.y));
//        }
//    }

    private static Point getMaxAndMin(int start, int end, int idx, int a, int b) {
        if (a > end || b < start)
            return new Point(Integer.MIN_VALUE, Integer.MAX_VALUE);

        if (start >= a && end <= b)
            return tree[idx];

        int mid = (start + end) / 2;
        Point left = getMaxAndMin(start, mid, idx * 2, a, b);
        Point right = getMaxAndMin(mid + 1, end, idx * 2 + 1, a, b);

        return new Point(Math.max(left.x, right.x), Math.min(left.y, right.y));
    }

    private static Point setSegmentTree(int start, int end, int idx) {
        if (start == end)
            return tree[idx] = new Point(map[start], map[end]);

        int mid = (start + end) / 2;
        Point left = setSegmentTree(start, mid, idx * 2);
        Point right = setSegmentTree(mid + 1, end, idx * 2 + 1);

        return tree[idx] = new Point(Math.max(left.x, right.x), Math.min(left.y, right.y));
    }

    private static int getTreeSize() {
        int h = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        return (int) Math.pow(2, h);
    }
}