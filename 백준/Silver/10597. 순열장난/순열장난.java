import java.util.*;
import java.io.*;

class Main {
    static String str;
    static int N;
    static boolean[] check = new boolean[51];

    static void backtracking(int idx, int max, String ans){
        if(idx==N){
            for(int i=1;i<=max;i++){
                if(!check[i]) return;
            }

            System.out.println(ans);
            System.exit(0);
        }

        String s = str.substring(idx,idx+1);
        int num = Integer.parseInt(s);
        if(!check[num]){
            check[num] = true;
            backtracking(idx+1, (num>max)? num : max, ans+" "+s);
            check[num] = false;
        }

        if(idx < N-1){
            s = str.substring(idx, idx+2);
            num = Integer.parseInt(str.substring(idx, idx+2));
            if(num<51 && !check[num]){
                check[num] = true;
                backtracking(idx+2, (num>max)? num : max, ans+" "+s);
                check[num] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        N = str.length();
        backtracking(0, 0, "");

    }
}