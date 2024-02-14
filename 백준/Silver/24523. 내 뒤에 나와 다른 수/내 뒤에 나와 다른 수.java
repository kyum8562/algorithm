import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] update = new long[N + 1];
        int start = 0, cnt = 0;
        for (int i = 1; i < N ; i++) {
            if (cnt == 0) {
                start = i;
                cnt = 1;
            }
            if (arr[i] == arr[i + 1]) {
                cnt++;
            } else {
                update[start] += i + 1;
                update[start + cnt] += -(i + 1);
                cnt = 0;
            }
        }

        for (int i = 1; i <= N; i++) {
            update[i] += update[i - 1];

            if(update[i] == 0) update[i] = -1;
        }

        for (int i = 1; i <= N; i++) {
            sb.append(update[i] + " ");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}