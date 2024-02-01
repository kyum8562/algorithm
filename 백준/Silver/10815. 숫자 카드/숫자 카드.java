import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr); // 오름차순 정렬

        Map<Integer, Integer> map = new LinkedHashMap<>();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i ++){
            int tgt = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(tgt)).append(" ");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int tgt) {
        int s = 0;
        int e = N-1;
        int m;
        int res = -1;

        while(e >= s){
            m = (s + e) / 2;

            if(arr[m] > tgt) e = m - 1;
            else if(arr[m] < tgt) s = m + 1;
            else{
                res = m;
                break;
            }
        }
        return res == -1 ? 0 : 1;
    }
}