import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long sum = 0L;

        int[] arr = new int[N+1];
        int[] prefixSum = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i ++){
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
            prefixSum[i] = prefixSum[i-1] + tmp;
        }

        for(int i = 1 ; i < N ; i ++)
            sum += (prefixSum[N] - prefixSum[i]) * arr[i];

        System.out.println(sum);
    }
}