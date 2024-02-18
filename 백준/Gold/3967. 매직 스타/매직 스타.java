import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, arr2, choice;
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        N = 0;
        arr = new int[12]; // 정답지
        v = new boolean[12];

        for(int i = 0 ; i < 5 ; i ++){
            String s = br.readLine();
            for(int j = 0 ; j < 9 ; j ++){
                char cur = s.charAt(j);
                if(cur == '.') continue;
                if(cur >= 'A' && cur <= 'L'){
                    int tmp = cur - 'A';
                    arr[cnt] = tmp;
                    v[tmp] = true;
                }
                else{
                    arr[cnt] = -1;
                    N ++;
                }
                cnt ++;
            }
        }

        choice = new int[N];

        perm(0);
    }

    private static void perm(int depth) {
        if(depth == N){
            arr2 = new int[12];
            for(int i = 0 ; i < 12 ; i ++)
                arr2[i] = arr[i];

            int cnt = 0;
            for(int i = 0 ; i < 12 ; i ++){
                if(arr2[i] == -1)
                    arr2[i] = choice[cnt++];
            }

            if(check(arr2)){
                printingAns(arr2);
                System.out.println(sb);
                System.exit(0);
            }
            return;
        }

        for(int i = 0 ; i < 12 ; i ++){
            if(v[i]) continue;
            v[i] = true;
            choice[depth] = i;
            perm(depth+1);
            v[i] = false;
        }
    }

    private static void printingAns(int[] arr) {
        sb.append("....").append(parseChar(arr[0])).append("....\n");
        sb.append(".").append(parseChar(arr[1])).append(".").append(parseChar(arr[2])).append(".").append(parseChar(arr[3])).append(".").append(parseChar(arr[4])).append(".\n");
        sb.append("..").append(parseChar(arr[5])).append("...").append(parseChar(arr[6])).append("..\n");
        sb.append(".").append(parseChar(arr[7])).append(".").append(parseChar(arr[8])).append(".").append(parseChar(arr[9])).append(".").append(parseChar(arr[10])).append(".\n");
        sb.append("....").append(parseChar(arr[11])).append("....\n");
    }

    private static char parseChar(int i) {
        if(i == 0) return 'A';
        else if(i == 1) return 'B';
        else if(i == 2) return 'C';
        else if(i == 3) return 'D';
        else if(i == 4) return 'E';
        else if(i == 5) return 'F';
        else if(i == 6) return 'G';
        else if(i == 7) return 'H';
        else if(i == 8) return 'I';
        else if(i == 9) return 'J';
        else if(i == 10) return 'K';
        else return 'L';
    }

    private static boolean check(int[] arr) {
        if(arr[1] + arr[2] + arr[3] + arr[4] != 22)
            return false;
        if(arr[7] + arr[8] + arr[9] + arr[10] != 22)
            return false;
        if(arr[0] + arr[2] + arr[5] + arr[7] != 22)
            return false;
        if(arr[0] + arr[3] + arr[6] + arr[10] != 22)
            return false;
        if(arr[1] + arr[5] + arr[8] + arr[11] != 22)
            return false;
        if(arr[4] + arr[6] + arr[9] + arr[11] != 22)
            return false;

        return true;
    }
}