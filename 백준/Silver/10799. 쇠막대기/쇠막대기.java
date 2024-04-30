import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String s = br.readLine();

        int ans = 0;
        int len = s.length();
        for(int i = 0 ; i < len ; i ++){
            char curr = s.charAt(i);
            if(curr == '(') stack.push(curr);
            else{
                stack.pop();

                // 그 전 괄호가 열린 괄호면 레이저 의미
                if(s.charAt(i-1) == '(')
                    ans += stack.size();
                else
                    ans ++;
            }
        }
        System.out.println(ans);
    }
}