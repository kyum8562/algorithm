import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int sum = 0;
        int min = 1 << 30;
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++){
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
            sum += tmp;
            min = Math.min(min, tmp);
        }

        System.out.println(bs(min, sum));
    }

    private static int bs(int min, int sum) {
        int s = min;
        int e = sum;
        int m;

        while(e >= s){
            m = (s + e) / 2;

            if(isAvail(m) > M){
                s = m + 1;
            }
            else{
                e = m - 1;
            }
        }

        return s;
    }

    private static int isAvail(int val) {
        int cnt = 1;
        int sum = val;

        for(int i = 0 ; i < N ; i ++){
            sum -= arr[i];

            if(sum < 0){
                cnt ++;
                sum = val;
            }
        }

        return cnt;
    }
}