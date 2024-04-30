import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int ans = 0;

        Stack<Integer>[] stack = new Stack[P + 1];
        for (int i = 1; i <= P; i++)
            stack[i] = new Stack<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 해당 스택이 비어있을 경우
            if (stack[a].isEmpty()) {
                stack[a].push(b);
                ans++;
            }
            // 해당 스택이 비어있지 않을경우
            else {
                // b보다 작거나 같을 때까지 빼줌
                while (!stack[a].isEmpty()) {
                    if (stack[a].peek() > b) {
                        ans ++;
                        stack[a].pop();
                    } else break;
                }

                // 해당 스택에서 b를 찾지 못했을 때
                if(stack[a].isEmpty() || stack[a].peek() != b){
                    stack[a].push(b);
                    ans ++;
                }
            }
        }

        System.out.print(ans);
    }
}