import java.io.*;
import java.util.*;

// 중복 순열
public class Main {
    static int N, ans=0;
    static int[] choice;

    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        choice = new int[N];
        perm(0);
        System.out.println(ans);
    }

    private static void perm(int depth) {
        if(depth >= 1 && choice[0] == 0) return;

        if(depth == N){
            String s = "";
            for(int i = 0 ; i < N ; i ++)
                s += choice[i];

            int res = Integer.parseInt(s);

            if(res % 3 == 0 && res != 0) ans ++;
            return;
        }

        for(int i = 0 ; i <= 2 ; i ++){
            choice[depth] = i;
            perm(depth+1);
        }
    }
}