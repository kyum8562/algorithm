import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int te = Integer.parseInt(st.nextToken()) - 1;
        int ts = Integer.parseInt(st.nextToken()) - 1;
        int tm = Integer.parseInt(st.nextToken()) - 1;

        int ce = 0;
        int cs = 0;
        int cm = 0;

        int year = 1;

        while(true){
            if(te == ce && ts == cs && tm == cm) break;

            ce = (ce + 1) % 15;
            cs = (cs + 1) % 28;
            cm = (cm + 1) % 19;

            year ++;
        }

        System.out.println(year);
    }
}