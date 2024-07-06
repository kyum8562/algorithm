import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i ++){
            String s = br.readLine();

            int[] flag1 = check(0, s.length()-1, s);
            if(flag1[0] == 1) sb.append(0);
            else{
                int[] flag2 = check(flag1[1]+1, flag1[2], s);
                int[] flag3 = check(flag1[1], flag1[2]-1, s);

                if(flag2[0] == 1 || flag3[0] == 1) sb.append(1);
                else sb.append(2);
            }

            sb.append("\n");
        }
        
        System.out.print(sb);
    }

    static int[] check(int left, int right, String s){
        while(right > left){
            if(s.charAt(left++) == s.charAt(right--)) continue;
            return new int[] {0, left-1, right+1};
        }

        return new int[] {1, 0, 0};
    }
}