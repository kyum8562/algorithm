import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        Integer[] B = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            A[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(A);

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            B[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(B, Comparator.reverseOrder());

        int ans = 0;
        for(int i = 0 ; i < N ; i ++)
            ans += A[i] * B[i];

        System.out.println(ans);
    }
}