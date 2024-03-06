import java.io.*;
import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        char type = s.charAt(0); // 열린괄호는 0 닫힌괄호는 1
        int len = s.length();
        int sum = 10;
        for(int i = 1 ; i < len ; i ++){
            char cur = s.charAt(i);
            if(cur == type)
                sum += 5;
            else{
                sum += 10;
                type = cur;
            }
        }
        System.out.println(sum);
    }
}