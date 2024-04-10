import java.io.*;
import java.util.*;

public class Main {
    static int postIdx = 1;
    static int[] inOrder, postOrder, preOrder;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        inOrder = new int[N+1];
        postOrder = new int[N+1];
        preOrder = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            inOrder[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            postOrder[i] = Integer.parseInt(st.nextToken());

        recur(1, N, 1, N);

        for(int i = 1 ; i <= N ; i ++)
            sb.append(preOrder[i]).append(" ");

        System.out.print(sb);
    }

    private static void recur(int inOrder_S, int inOrder_E, int postOrder_S, int postOrder_E) {
        if(inOrder_S > inOrder_E || postOrder_S > postOrder_E) return;

        int root = postOrder[postOrder_E];
        preOrder[postIdx++] = postOrder[postOrder_E];

        int rootIdx = inOrder[root];
        for(int i = inOrder_S ; i <= inOrder_E ; i ++){
            if(inOrder[i] == postOrder[postOrder_E]){
                rootIdx = i;
                break;
            }
        }

        recur(inOrder_S, rootIdx-1, postOrder_S, postOrder_S + rootIdx - inOrder_S -1);
        recur(rootIdx+1, inOrder_E, postOrder_S+rootIdx-inOrder_S, postOrder_E-1);
    }
}