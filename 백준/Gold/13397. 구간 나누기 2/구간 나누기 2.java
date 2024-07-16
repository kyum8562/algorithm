import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, minArr, maxArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int sum = 0;
        arr = new int[N];
        minArr = new int[N];
        maxArr = new int[N];

        Arrays.fill(minArr, 1 << 30);

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++){
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
            sum += tmp;

            minArr[i] = Math.min(minArr[i], tmp);
            maxArr[i] = Math.min(maxArr[i], tmp);
        }

        System.out.println(bs(sum));
    }

    private static int bs(int sum) {
        int s = 0;
        int e = sum;
        int m;
        int ans = 0;

        while(e >= s){
            // 구간의 점수
            m = (s + e) / 2;

            if(isAvail(m) > M) s = m + 1;
            else{
                e = m - 1;
                ans = m;
            }
        }

        return ans;
    }

    private static int isAvail(int val) {
        int cnt = 1;
        int max = arr[0];
        int min = arr[0];

        for(int i = 0 ; i < N ; i ++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);

            if(max - min > val){
                cnt ++;

                max = arr[i];
                min = arr[i];
            }
        }

        return cnt;
    }
}