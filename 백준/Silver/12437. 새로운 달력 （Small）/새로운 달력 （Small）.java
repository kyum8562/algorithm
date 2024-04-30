import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T ; t ++){
            st = new StringTokenizer(br.readLine());
            int monthLen = Integer.parseInt(st.nextToken());
            int daysInMonth = Integer.parseInt(st.nextToken());
            int daysInWeek = Integer.parseInt(st.nextToken());

            int line = 0;
            int lastMonthSpareDays = 0;

            // 월만큼 반복
            for(int i = 0 ; i < monthLen ; i ++){

                // 총 일수: 한달 내 일수 + 이전 달의 남은 일수
                int sum = daysInMonth + lastMonthSpareDays;
                // 총 일수 / 주당일수: (한 주를 꽉채우는 주가) 몇 주인지 계산
                line += sum / daysInWeek;

                // 나누어 떨어질 때
                if(sum % daysInWeek == 0)
                    lastMonthSpareDays = 0;
                // 나누어 떨어지지 않을 때
                else{
                    line ++; // 라인 증가
                    lastMonthSpareDays = sum % daysInWeek;
                }
            }

            sb.append("Case #" + t + ": ").append(line).append("\n");
        }

        System.out.println(sb);
    }
}