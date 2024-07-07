import java.io.*;
import java.util.*;

public class Main {
    static String S;
    static int ans = 0, SLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        String T = br.readLine();
        SLen = S.length();

        recur(T);

        System.out.print(ans);
    }

    private static void recur(String T) {
        int TLen = T.length();
        if (TLen == SLen) {
            if (T.equals(S)) ans = 1;
            return;
        }

        if(T.endsWith("A"))
            recur(T.substring(0, TLen-1));

        if(T.startsWith("B"))
            recur(new StringBuilder(T.substring(1)).reverse().toString());
    }
}