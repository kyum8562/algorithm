import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int idx = 0;
        int max = 0;
        for(int i = 1 ; i <= 5 ; i ++){
            st = new StringTokenizer(br.readLine());
            int sum = 0;

            for(int j = 0 ; j < 4 ; j ++)
                sum += Integer.parseInt(st.nextToken());

            if(sum > max){
                max = sum;
                idx = i;
            }
        }

        System.out.println(idx + " " + max);
    }
}