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

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i ++){
            int tgt = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(tgt, 1) - binarySearch(tgt, 0)).append(" ");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int tgt, int type) {
        int s = 0;
        int e = N;
        int m;

        while(e > s){
            m = (s + e) / 2;

            if(type == 0){ // lower_bound
                if(arr[m] >= tgt) e = m;
                else s = m + 1;
            }
            else{ // upper_bound
                if(arr[m] > tgt) e = m;
                else s = m + 1;
            }
        }
        return s;
    }
}