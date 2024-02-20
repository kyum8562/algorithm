import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i);
            if(cur >= 65 && cur <= 90)
                cur += 32;
            else
                cur -= 32;
            sb.append((char)cur);
        }
        System.out.println(sb);
    }
}