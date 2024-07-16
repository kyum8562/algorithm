import java.io.*;
import java.util.*;

public class Main {
    static int N, M, C;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 소의 수
        M = Integer.parseInt(st.nextToken()); // 소를 운반하는 버스
        C = Integer.parseInt(st.nextToken()); // 각 버스에 탈 수 있는 소의 수

        int max = 0;
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++){
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
            max = Math.max(max, tmp);
        }

        Arrays.sort(arr);

        System.out.println(bs(max));
    }

    private static int bs(int max) {
        int s = 0;
        int e = max;
        int m;

        while(e >= s){
            // 소가 대기하는 시간
            m = (s + e) / 2;

            if(isAvailable(m)) e = m - 1;
            else s = m + 1;
        }

        return s;
    }

    private static boolean isAvailable(int m) {
        int s = 0;
        int busCnt = 1;

        for(int e = 1 ; e < N ; e ++){
            // 탈수있는 소의 수에 맞게 태웠을 때, 대기시간보다 m이 크거나 같다면 => 패스
            if(C > e - s && m >= arr[e] - arr[s]) continue;

            // 버스 사용
            busCnt ++;
            s = e;
        }

        return M >= busCnt;
    }
}