import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        Stack<Character> stack;

        for(int i = 0 ; i < N ; i ++){
            stack = new Stack<>();

            String s = br.readLine();
            int len = s.length();

            stack.push(s.charAt(0));

            for(int j = 1 ; j < len ; j ++){
                char cur = s.charAt(j);
                char peek;

                // 스택이 비어있다면 push
                if(stack.size() == 0) stack.push(cur);

                // 비어있지 않다면
                else{
                    peek = stack.peek();

                    if(peek == cur) stack.pop();
                    else stack.push(cur);
                }
            }

            if(stack.size() == 0) ans ++;
        }

        System.out.print(ans);
    }
}