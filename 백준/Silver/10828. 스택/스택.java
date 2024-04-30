import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            String action = st.nextToken();

            if(action.equals("push")) stack.push(Integer.parseInt(st.nextToken()));
            else if(action.equals("pop")) sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
            else if(action.equals("size")) sb.append(stack.size()).append("\n");
            else if(action.equals("empty")) sb.append(stack.isEmpty() ? 1 : 0).append("\n");
            else if(action.equals("top")) sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
        }

        System.out.println(sb);
    }
}