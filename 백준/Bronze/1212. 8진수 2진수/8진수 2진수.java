import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            String cur = Integer.toBinaryString(s.charAt(i) - '0');
            if(cur.length() == 3) sb.append(cur);
            else if(cur.length() == 2 & i != 0) sb.append("0").append(cur);
            else if(cur.length() == 1 & i != 0) sb.append("00").append(cur);
            else sb.append(cur);
        }

        System.out.println(sb);
    }
}