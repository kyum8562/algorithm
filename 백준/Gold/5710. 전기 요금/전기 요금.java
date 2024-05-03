import java.io.*;
import java.util.*;

class Main {
    // 7 ~ 19: 1분에 10원
    // 19: 7: 1분에 5원
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int ans;

        while(true){
            st = new StringTokenizer(br.readLine());
            // A: (이웃의 사용량 + 상근이 사용량)의 전기요금
            // B: |상근이 전기요금 - 이웃 전기요금|
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int allWart = getWart(A);

            if(A == 0 && B == 0) break;

            // 상근이가 내야하는 요금은?
            int l = 0;
            int r = allWart / 2;
            int m = 0;

            while(r >= l){
                // 상근이의 사용량
                m = (l + r) / 2;

                // 상근이 요금, 이웃 요금
                int sangGenUsed = getElecPrice(m);
                int neighborUsed = getElecPrice(allWart - m);

                // 상근이 요금 - 이웃 요금의 절대값
                int diff = Math.abs(sangGenUsed - neighborUsed);

                // 절대값의 차가 작다는 것은
                if(diff < B) r = m - 1;
                else if(diff > B) l = m + 1;
                else{
                    // 상근이의 요금(둘중 더 작음)
                    sb.append(sangGenUsed).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    private static int getWart(int m) {
        if(m <= 200) {
            return m / 2;
        } else if(m <= 29_900) {
            return (m - 200) / 3 + 100;
        } else if(m <= 4_979_900) {
            return (m - 29_900) / 5 + 10_000;
        } else {
            return (m - 4_979_900) / 7 + 1_000_000;
        }
    }

    private static int getElecPrice(int m) {
        if(m <= 100)
            return m * 2;
        else if(m <= 10_000)
            return 100 * 2 + (m-100) * 3;
        else if(m <= 1_000_000)
            return 100 * 2 + 9900 * 3 + (m-10_000) * 5;
        else
            return 100 * 2 + 9900 * 3 + 990_000 * 5 + (m-1_000_000) * 7;
    }
}