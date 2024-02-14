import java.io.*;
import java.util.*;

public class Main {
    static int N, max;
    static int[] prefix;
    static List<Integer> list;
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T -- > 0) {
            N = Integer.parseInt(br.readLine());
            prefix = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            max = 0;
            for (int i = 1; i <= N; i++) {
                int num = Integer.parseInt(st.nextToken());
                prefix[i] = prefix[i - 1] + num;
                max = Math.max(max, num);
            }

            list = new ArrayList<>();

            getSosu();

            int len, sum, s, e, cnt;
            int listSize = list.size();
            int answer = Integer.MAX_VALUE;
            for (int i = 0; i < listSize; i++) {
                len = 0;
                cnt = 0;
                sum = list.get(i);

                s = 0; e = 1;
                while (e <= N) {
                    if (prefix[e] - prefix[s] == sum) {
                        len += e - s - 1;
                        s = e;
                        e++;
                        cnt++;
                    } else {
                        e++;
                    }
                }

                if (cnt == prefix[N] / sum)
                    answer = Math.min(answer, len);
            }

            if(prefix[N] != 0) sb.append(answer+"\n");
            else sb.append(0 + "\n");
        }

        System.out.println(sb);
    }

    private static void getSosu() {
        for (int i = 1; i * i <= prefix[N] ; i++) {
            if (prefix[N] % i == 0) {
                if(i >= max) list.add(i);
                if (i * i != prefix[N]) {
                    if (prefix[N] / i >= max) {
                        list.add(prefix[N] / i);
                    }
                }
            }
        }
    }
}