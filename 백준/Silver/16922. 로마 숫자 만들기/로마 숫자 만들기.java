import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Set<Integer> set = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        comb(0, 0, 0); // 중복 조합
        System.out.println(set.size());
    }

    private static void comb(int depth, int start, int sum) {
        if(depth == N){
            set.add(sum);
            return;
        }

        for (int i = start ; i < 4 ; i++) {
            // 마킹
            int ans = 0;
            if(i == 0) ans = 1;
            else if(i == 1) ans = 5;
            else if(i == 2) ans = 10;
            else ans = 50;
            comb(depth+1, i, sum + ans);
        }
    }
}