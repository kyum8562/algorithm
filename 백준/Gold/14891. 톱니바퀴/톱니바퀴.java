import java.io.*;
import java.util.*;

/**
 * 하나를 회전시킬 때, 맞닿은 톱니바퀴와 극이 다르다면,
 * 맞닿은 쪽은 A가 회전한 반대방향으로 회전한다.
 * <p>
 * N극: 1
 * S극: 0
 * 시계: 1
 * 반시계: -1
 */
public class Main {
    static int N;
    static int[][] rolls;
    static int[] move = {-1, 1};
    static boolean[] v;
    static int[] isRotate;
    static class Node{
        int t;
        int d;
        public Node(int t, int d){
            this.t = t;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        rolls = new int[4][8];

        for (int a = 0; a < 4; a++) {
            String s = br.readLine();
            for (int i = 0; i < 8; i++) {
                rolls[a][i] = s.charAt(i) - '0';
            }
        }

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            // 회전할 톱니바퀴 인덱스 찾기
            searchingRotateNum(t, d);

            // 톱니바퀴 회전
            for(int j = 0 ; j < 4 ; j ++){
                if(isRotate[j] != 0)
                    rolls[j] = rotation(rolls[j], isRotate[j]);
            }
        }

        int ans = 0;
        if(rolls[0][0] == 1) ans += 1;
        if(rolls[1][0] == 1) ans += 2;
        if(rolls[2][0] == 1) ans += 4;
        if(rolls[3][0] == 1) ans += 8;

        System.out.println(ans);
    }

    private static void searchingRotateNum(int t, int di) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(t, di));
        isRotate = new int[4];

        while(!q.isEmpty()){
            Node curr = q.poll();

            isRotate[curr.t] = curr.d;
            int currLeft = rolls[curr.t][2];
            int currRight = rolls[curr.t][6];

            for(int d = 0 ; d < 2 ; d ++){
                int next = curr.t + move[d];

                if(isValid(next) && isRotate[next] == 0){
                    if(next > curr.t){
                        if(currLeft != rolls[next][6]){
                            q.offer(new Node(next, -curr.d));
                        }
                    }
                    else{
                        if(currRight != rolls[next][2]){
                            q.offer(new Node(next, -curr.d));
                        }
                    }
                }
            }
        }
    }

    private static int[] rotation(int[] roll, int d) {
        if (d == 1) {
            int tmp = roll[7];
            for (int i = 6; i >= 0; i--) {
                roll[i + 1] = roll[i];
            }
            roll[0] = tmp;
        } else {
            int tmp = roll[0];
            for (int i = 1; i < 8; i++) {
                roll[i - 1] = roll[i];
            }
            roll[7] = tmp;
        }
        return roll;
    }

    private static boolean isValid(int n){
        return (n >= 0 && n < 4);
    }
}