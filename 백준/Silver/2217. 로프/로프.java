import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int max = -(1 << 30);

        int[] arr = new int[N];
        for (int i = 0; i < N; i ++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int idx = 1;
        for (int i = N-1; i >= 0; i --)
            max = Math.max(max, arr[i] * idx++);

        System.out.println(max);
    }
}