import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 오름차순 정렬
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i ++)
            sb.append(bs(0, N-1, Integer.parseInt(st.nextToken()))).append("\n");

        System.out.print(sb);
    }

    private static int bs(int s, int e, int tgt) {
        int m;

        while(e >= s){
            m = (s + e) / 2;

            // tgt보다 값이 클 경우, m ~ e 범위를 후보군에서 제거함
            if(arr[m] > tgt) e = m-1;
            // tgt보다 값이 작을 경우, s ~ m 범위를 후보군에서 제거함
            else if(arr[m] < tgt) s = m+1;
            else return 1;
        }

        return 0;
    }
}