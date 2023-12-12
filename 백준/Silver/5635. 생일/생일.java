import java.io.*;
import java.util.*;

public class Main {

    static int ans;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] max = new int[4]; // 나이가 제일 많은 사람
    static int[] min = new int[4]; // 나이가 제일 적은 사람
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < 4; i++) max[i] = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
            int a = Integer.parseInt(st.nextToken()); // 일
            int b = Integer.parseInt(st.nextToken()); // 월
            int c = Integer.parseInt(st.nextToken()); // 년

            if (max[3] > c) updateMax(i, a, b, c);
            else if (c == max[3]) {
                if (max[2] > b) updateMax(i, a, b, c);
                else if(max[2] == b){
                    if(max[1] > a) updateMax(i, a, b, c);
                }
            }
            if (c > min[3]) updateMin(i, a, b, c);
            else if (c == min[3]) {
                if (b > min[2]) updateMin(i, a, b, c);
                else if(min[2] == b){
                    if(a > max[1]) updateMin(i, a, b, c);
                }
            }
        }
        System.out.println(arr[min[0]]);
        System.out.println(arr[max[0]]);
    }
    static void updateMax(int i, int a, int b, int c){
        max[0] = i;
        max[1] = a;
        max[2] = b;
        max[3] = c;
    }
    static void updateMin(int i, int a, int b, int c){
        min[0] = i;
        min[1] = a;
        min[2] = b;
        min[3] = c;
    }
}