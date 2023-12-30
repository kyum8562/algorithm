import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());  //테스트 케이스 개수
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;  //수들의 합
            while (st.hasMoreTokens()) {
                //입력받는 수들은 바로 합에 더해준다
                sum += Integer.parseInt(st.nextToken()); 
            }
            sb.append(sum + "\n");
        }
        System.out.print(sb);
    }
}