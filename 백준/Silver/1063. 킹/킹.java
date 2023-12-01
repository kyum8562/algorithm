import java.io.*;
import java.util.*;

public class Main {
    static int qr, qc, sr, sc, movCnt;
//    static int[] dr = {0, 0, 1, -1, -1, -1, 1, 1};
//    static int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dr = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dc = {0, 0, -1, 1, 1, 1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        qr = parseRow(s.charAt(0)); // 퀸 좌표
        qc = s.charAt(1) - '0' -1;

        s = st.nextToken();
        sr = parseRow(s.charAt(0)); // 돌맹이 좌표
        sc = s.charAt(1) - '0' -1;

        movCnt = Integer.parseInt(st.nextToken()); // 이동 횟수
        while(movCnt -- > 0){
            movNext(br.readLine());
        }

        char ansQr = reverseParseRow(qr);
        char ansSr = reverseParseRow(sr);
        System.out.println(ansQr+""+(qc+1));
        System.out.println(ansSr+""+(sc+1));
    }

    private static void movNext(String dir) {
        int type = calType(dir);
        int nr = qr + dr[type];
        int nc = qc + dc[type];

        // validation check
        if(!isValid(nr, nc)) return;
        // 가려는 방향에 돌이 있을 경우, 돌 이동 validation check
        if(nr == sr && nc == sc){
            if(!isValid(nr+dr[type], nc+dc[type])) return;
            else{
                sr += dr[type];
                sc += dc[type];
            }
        }
        qr = nr;
        qc = nc;
    }

    private static int calType(String dir) {
        if(dir.equals("R")) return 0;
        else if(dir.equals("L")) return 1;
        else if(dir.equals("B")) return 2;
        else if(dir.equals("T")) return 3;
        else if(dir.equals("RT")) return 4;
        else if(dir.equals("LT")) return 5;
        else if(dir.equals("RB")) return 6;
        else return 7;
    }

    private static boolean isValid(int nr, int nc) {
        return(nr>=0 && nr<8 && nc>=0 && nc<8);
    }

    private static int parseRow(char c) {
        if (c == 'A') return 0;
        else if (c == 'B') return 1;
        else if (c == 'C') return 2;
        else if (c == 'D') return 3;
        else if (c == 'E') return 4;
        else if (c == 'F') return 5;
        else if (c == 'G') return 6;
        else return 7;
    }
    private static char reverseParseRow(int c) {
        if (c == 0) return 'A';
        else if (c == 1) return 'B';
        else if (c == 2) return 'C';
        else if (c == 3) return 'D';
        else if (c == 4) return 'E';
        else if (c == 5) return 'F';
        else if (c == 6) return 'G';
        else return 'H';
    }
}