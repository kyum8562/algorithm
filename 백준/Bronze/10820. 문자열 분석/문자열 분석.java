import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int smallChar, bigChar, number, space;
        String s;

        while((s = br.readLine()) != null){
            int len = s.length();

            smallChar = 0;
            bigChar = 0;
            number = 0;
            space = 0;

            for(int i = 0 ; i < len ; i ++){
                int cur = s.charAt(i);

                if(cur == 32) space ++;
                else if(cur >= 97 && cur <= 122) smallChar ++;
                else if(cur >= 65 && cur <= 90) bigChar ++;
                else number ++;
            }

            sb.append(smallChar).append(" ").append(bigChar).append(" ").append(number).append(" ").append(space).append("\n");
        }

        System.out.print(sb);
    }
}