import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int max = 0;
        int secondMax = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++){
            int cur = Integer.parseInt(st.nextToken());

            max ++;
            
            if(cur == 1){
                max = Math.max(max, secondMax + 1);
                secondMax = 0;
            }
            else secondMax += 2;

        }

        System.out.print(Math.max(max, secondMax));
    }
}