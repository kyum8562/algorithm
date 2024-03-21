import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long ans = 0;

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            ans += Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        for(int i = 0 ; i < N ; i ++)
            ans += arr[i] * i;

        System.out.print(ans);
    }
}