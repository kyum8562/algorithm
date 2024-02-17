import java.io.*;
import java.util.*;

public class Main {
    static int aLen, B, max;
    static int[] map, choice;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();
        aLen = a.length();

        if(aLen > b.length())
            System.out.println(-1);
        else{
            B = Integer.parseInt(b);
            max = -1;

            map = new int[aLen];
            choice = new int[aLen];
            v = new boolean[aLen];

            for(int i = 0 ; i < aLen ; i ++)
                map[i] = a.charAt(i) - '0';

            perm(0);

            System.out.println(max);
        }
    }

    private static void perm(int depth) {
        if(depth == aLen){
            if(choice[0] == 0) return;
            
            String s = "";
            for(int i = 0 ; i < aLen ; i ++)
                s += choice[i];

            int A = Integer.parseInt(s);

            if(B > A)
                max = Math.max(max, A);
            return;
        }
        for(int i = 0 ; i < aLen ; i ++){
            if(v[i]) continue;
            v[i] = true;
            choice[depth] = map[i];
            perm(depth+1);
            v[i] = false;
        }
    }
}