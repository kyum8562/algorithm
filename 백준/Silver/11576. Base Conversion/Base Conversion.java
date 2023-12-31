import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        st = new StringTokenizer(br.readLine(), " ");

        int sum = 0;

        //A진법 -> 10진법
        for (int i = m - 1; i >= 0; i--) {
            int N = Integer.parseInt(st.nextToken());
            sum += N * Math.pow(A, i);
        }

        //10진법 -> B진법
        while (sum != 0) {
            stack.push(sum % B);
            sum /= B;
        }

        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }
}