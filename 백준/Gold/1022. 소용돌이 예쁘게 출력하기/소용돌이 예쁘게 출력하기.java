import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int r1, c1, r2, c2, max = 0;
    private static int[][] map;
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        map = new int[r2 - r1 + 1][c2 - c1 + 1];

        fill();
        print();
    }

    private static void fill() {
        int x = 0, y = 0, dir = 0;
        int num = 1, dnum = 1, cnt = 0;

        while (!isFinish()) {
            if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
                map[x - r1][y - c1] = num;
            }
            num++;
            cnt++;
            x = x + dx[dir];
            y = y + dy[dir];

            if (cnt == dnum) {
                cnt = 0;
                if (dir == 1 || dir == 3) dnum++;
                dir = (dir + 1) % 4;
            }
        }
        max = num - 1;
    }

    private static void print() {
        int maxLen = (int) Math.log10(max), len;

        for (int i = 0; i <= r2 - r1; i++) {
            for (int j = 0; j <= c2 - c1; j++) {
                len = maxLen - (int) Math.log10(map[i][j]);
                for (int k = 0; k < len; k++) {
                    System.out.print(" ");
                }
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isFinish() {
        return map[0][0] != 0 && map[r2 - r1][0] != 0 && map[0][c2 - c1] != 0 && map[r2 - r1][c2 - c1] != 0;
    }
}