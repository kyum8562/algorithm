import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long sum = 0; // 나머지 수의 합
        int max = 0; // 가장 큰 수
        long ans = 0; // 정답

        int[] arr = new int[N];

        for(int i = 0 ; i < N ; i ++){
            int tmp = Integer.parseInt(br.readLine());
            arr[i] = tmp;

            max = Math.max(max, tmp);
            sum += tmp;
        }

        sum -= max;

        /**
         * 행동 1: 2개 (가장 큰 수와 나머지의 수)를 선택해서 빼는 방법
         * - 이 경우는 가장 큰 수에서 1 나머지 수에서 1을 빼주면 된다.
         * 행동 2: 2개 (나머지의 수)를 선택해서 빼는 방법
         * - 이 경우는 나머지 수의 합에서 2를 빼주면 된다(2개 수를 1씩 빼주므로)
         */

        // max가 나머지의 합보다 클 경우
        if(max > sum)
            ans = max - sum;
        // 같을 경우
        else if(max == sum)
            ans = 0;
        // 나머지의 합이 더 클 경우
        else{
            // 둘다 짝수일 경우 나머지의 합과 max 수가 언젠가는 동일해짐 -> 0
            // 홀 + 홀 = 짝
            // 짝 + 짝 = 짝
            if((max+sum) % 2 == 0) ans = 0;
            // 짝 + 홀 = 홀 의 경우에는 언젠가는 나머지의 합이 max와 1차이 날 것임 -> 1
            else ans = 1;
        }

        System.out.println(ans);
    }
}