import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer> list = new ArrayList<>();
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            map[i] = Integer.parseInt(st.nextToken());

        for(int i = N ; i >= 1 ; i--){
            int curr = map[i];
            list.add(curr, i);
        }

        for(int i: list)
            System.out.print(i + " ");
    }
}