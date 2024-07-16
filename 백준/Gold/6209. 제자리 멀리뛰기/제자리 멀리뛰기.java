import java.io.*;
import java.util.*;

public class Main {
    static int D, N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        D = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int sum = 0;
        arr = new int[N+1];

        arr[0] = 0;

        for(int i = 1 ; i <= N ; i ++){
            int tmp = Integer.parseInt(br.readLine());
            arr[i] = tmp;
            sum += tmp;
        }

        Arrays.sort(arr);

        System.out.println(bs(sum));
    }

    private static int bs(int sum) {
        int s = 0;
        int e = D;
        int m, ans = 0;

        while(e >= s){
            // (돌섬을 제거했을 때의) 최소 간격
            m = (s + e) / 2;

            if(removeStoneCnt(m) > M) e = m - 1;
            else{
                ans = m;
                s = m + 1;
            }
        }

        return ans;
    }

    private static int removeStoneCnt(int val) {
        int cnt = 0; // 제거한 돌섬
        int idx = 0; // 학생 위치

        for(int i = 1 ; i <= N ; i ++){

            // 간격의 차(arr[i] - arr[idx])가 val보다 크거나 같으면, 최소 간격이 최대가 됨
            // => (pass) 학생을 한칸 이동
            if(arr[i] - arr[idx] >= val) idx = i;

            // 간격의 차(arr[i] - arr[idx])가 val보다 작으면, 최소 간격이 최대가되지 못함
            // => 돌섬 제거
            else cnt ++;
        }

        return cnt;
    }
}