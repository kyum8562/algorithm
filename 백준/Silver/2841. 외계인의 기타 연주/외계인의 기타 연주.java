import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int ans = 0;

        Stack<Integer>[] stack = new Stack[7];
        for(int i = 1 ; i <= 6 ; i ++)
            stack[i] = new Stack<>();

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 스택이 비어있지 않으며 stack의 마지막 값이 b보다 크다면
            while(!stack[a].isEmpty() && stack[a].peek() > b){
                stack[a].pop();
                ans++;
            }

            // 비어있거나 b가 stack의 마지막 값보다 크다면
            if(stack[a].isEmpty() || b > stack[a].peek()){
                stack[a].push(b);
                ans++;
            }
        }

        System.out.print(ans);
    }
}