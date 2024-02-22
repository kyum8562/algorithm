import java.io.*;
import java.util.*;

// 중복 순열
public class Main {
    static int N, ans = 0;
    static int[] map, choice;
    static List<int []> list = new ArrayList();
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new int[10];
        choice = new int[10];
        for(int i = 0 ; i < 10 ; i ++)
            map[i] = Integer.parseInt(st.nextToken());

        perm(0, -1, 1);

        System.out.println(ans);
    }

    private static void perm(int depth, int lastVal, int cnt) {
        if(cnt == 3) return;

        if(depth == 10){
            int correct = 0;
            for(int i = 0 ; i < 10 ; i ++){
                if(choice[i] == map[i]) correct ++;
            }

            if(correct >= 5) ans ++;
            return;
        }

        for(int i = 1 ; i <= 5 ; i ++){
            choice[depth] = i;

            if(lastVal == i)
                perm(depth+1, i, cnt+1);
            else
                perm(depth+1, i, 1);
        }
    }
}