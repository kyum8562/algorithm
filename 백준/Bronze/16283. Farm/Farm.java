import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken()); // 양이 먹는 사료량
        int b = Integer.parseInt(st.nextToken()); // 염소가 먹는 사료량
        int n = Integer.parseInt(st.nextToken()); // 양과 염소를 합한 수
        int w = Integer.parseInt(st.nextToken()); // 양과 염소가 소비한 사료량

        int cnt = 0;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if((i+j) != n) continue; // 양과 염소를 합한 수가 n이 아니면 패스!
                if((i*a) + (j*b) != w) continue; // 양과 염소가 소비한 사료량이 w가 아니면 패스!
                cnt ++;
                sb.append(i + " " + j);
            }
        }
        if(cnt == 0 || cnt > 1) System.out.println(-1);
        else System.out.println(sb);

    }
}