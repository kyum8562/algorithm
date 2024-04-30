import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String cur;
        Stack<Integer> stack;

        for(int i = 0 ; i < N ; i ++){
            cur = br.readLine();

            stack = new Stack<>();

            sb.append(check(cur, stack)).append("\n");
        }

        System.out.print(sb);
    }

    private static String check(String cur, Stack<Integer> stack) {
        int len = cur.length();

        for(int i = 0 ; i < len ; i ++){
            if(cur.charAt(i) == '(')
                stack.push(1);
            else{
                if(stack.isEmpty()) return "NO";
                else stack.pop();
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }
}