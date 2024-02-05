import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static long win, draw, lose;
    static int[] B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        B = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i ++)
            B[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(B);

        for(int i = 0 ; i < N ; i ++){
            int lower = binarySearch(A[i], 0); // lower
            int upper = binarySearch(A[i], 1); // upper

            if(upper-lower == 0){
                win += upper;
                lose += M - upper;
            }
            else{
                win += lower;
                draw += upper - lower;
                lose += M - upper;
            }
        }
        System.out.println(win + " " + lose + " " + draw);
    }

    private static int binarySearch(int T, int type) {
        int s = 0;
        int e = M;
        int m = 0;

        while(e > s){
            m = (s + e) / 2;

            if(type == 0){
                if(B[m] >= T) e = m;
                else s = m + 1;
            }
            else{
                if(B[m] > T) e = m;
                else s = m + 1;
            }
        }

        return s;
    }
}