import java.io.*;
import java.util.*;

class Main {
    // 7 ~ 19: 1분에 10원
    // 19: 7: 1분에 5원
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int sum = 0;

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            String[] s = st.nextToken().split(":");

            // 전화시작 시각
            int h = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);

            int mm = Integer.parseInt(st.nextToken()); // 분

            // 60분을 넘는지 체크
            int tmp = mm + m;
            if(tmp > 60)
                sum += cal(h, (60 - m)) + cal(h+1, (mm - 60 + m));
            else
                sum += cal(h, mm);
        }

        System.out.println(sum);
    }

    private static int cal(int h, int m) {
        return m * ((h >= 7 && h < 19) ? 10 : 5);
    }
}