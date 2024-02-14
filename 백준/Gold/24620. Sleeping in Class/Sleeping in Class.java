import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] prefix = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = 0, num;
            for (int i = 1; i <= N; i++) {
                num = Integer.parseInt(st.nextToken());
                prefix[i] = prefix[i - 1] + num;
                max = Math.max(max, num);
            }

            ArrayList<Integer> list = new ArrayList<>();
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


            int len, sum, s, e, cnt;
            int answer = Integer.MAX_VALUE;
            for (int i = 0; i < list.size(); i++) {
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

                // 모두 같은 숫자로 만들 수 없는 경우도 있음
                if (cnt == prefix[N] / sum) {
                    answer = Math.min(answer, len);
                }

            }

            if(prefix[N] != 0) sb.append(answer+"\n");
            else sb.append(0 + "\n");

        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}