import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T -- > 0){
            String s = br.readLine();
            int len = s.length();
            int currD = 0;
            int r = 0, c = 0;
            int minR = 0, minC = 0, maxR = 0, maxC = 0;
            for(int i = 0 ; i < len ; i ++){
                char action = s.charAt(i);

                if(action == 'F'){ // 앞으로 이동
                    r += dr[currD];
                    c += dc[currD];
                }
                else if(action == 'B'){ // 뒤로 이동
                    r -= dr[currD];
                    c -= dc[currD];
                }
                else if(action == 'L') currD = (currD+3)%4;
                else currD = (currD+1)%4;

                minR = Math.min(minR, r);
                maxR = Math.max(maxR, r);
                minC = Math.min(minC, c);
                maxC = Math.max(maxC, c);
            }
            System.out.println((maxR-minR)*(maxC-minC));
        }

    }
}