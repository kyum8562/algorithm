import java.io.*;
import java.util.*;

public class Main {
    static int[] map = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 12
    // 2007년 1월 1일 월요일(월 0 ~ 일 6)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int tmp = (M-1);
        int allDay = 0;
        for(int i = 1 ; i <= tmp ; i ++) allDay += map[i];
        allDay = (allDay+D-1)%7;

        // 요일 출력하기
        String ans = "";
        switch(allDay){
            case 0:
                ans = "MON";
                break;
            case 1:
                ans = "TUE";
                break;
            case 2:
                ans = "WED";
                break;
            case 3:
                ans = "THU";
                break;
            case 4:
                ans = "FRI";
                break;
            case 5:
                ans = "SAT";
                break;
            case 6:
                ans = "SUN";
                break;
        }
        System.out.println(ans);
    }
}