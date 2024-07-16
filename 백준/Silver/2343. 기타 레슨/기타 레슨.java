import java.io.*;
import java.util.*;

public class Main {
    static int N, M, C;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 강의 수
        M = Integer.parseInt(st.nextToken()); // 그룹(블루레이) 수

        int max = 0;
        int sum = 0;
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++){
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
            sum += tmp;
            max = Math.max(max, tmp);
        }

        System.out.println(bs(max, sum));
    }

    private static int bs(int max, int sum) {
        int s = max;
        int e = sum;
        int m;

        while(e >= s){
            // 블루레이 최대 시간
            m = (s + e) / 2;

            int cnt = getGroupCnt(m);

            // 그룹 수가 M보다 크다면,
            if(cnt > M) s = m + 1;
            else e = m - 1;
        }

        return s;
    }

    private static int getGroupCnt(int m) {
        int sum = 0;
        int bluerayCnt = 0;

        for(int i = 0 ; i < N ; i ++){
            if(sum + arr[i] > m){
                sum = 0;
                bluerayCnt ++;
            }

            sum += arr[i];
        }

        return sum > 0 ? bluerayCnt + 1 : bluerayCnt;
    }
}