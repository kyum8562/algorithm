import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N; // 헛간 개수
    static int[] barns; // 헛간 위치 담은 배열
    static long[] prefix;
    static long[] suffix;
    static int Q; // 쿼리 개수
    static int a=0, b=0; // a,b 가중치 변수

    static long calCost(int y){
        // 이게 무슨뜻이지..?
        if (y < 0 || y > 1000000) {
            return Long.MAX_VALUE;
        }
        return a*prefix[y] + b*suffix[y];
    }

    static long binarySearch(int start, int end) {
        long answer = Long.MAX_VALUE;

        while (start <= end) {
            int y = (start + end) / 2;
            long cost1 = calCost(y);
            long cost2 = calCost(y+1);
            if(cost1 > cost2){
                // 오른쪽 지점으로 이동했을 때 더 비용이 작다면 => 우측 탐색(좌측 버림)
                start = y+1;
            }else{
                end = y-1;
            }

            answer = Math.min(answer, cost1);
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        barns = new int[N];
        prefix = new long[1000002];
        suffix = new long[1000002];

        // 헛간 위치 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            barns[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(barns);

        // 구간합 입력
//        1 2 3 4 10
//        prefix[0] = 0;
//        prefix[1] = 1*1 -1; 0 prefix[0]+0
//        prefix[2] = 2*2 -1 -2;  1 0 prefix[1]+1
//        prefix[3] = 3*3 -1 -2 -3; 2 1 0 prefix[2]+2
//        prefix[4] = 4*4 -1 -2 -3 -4;  3 2 1 0 prefix[3]+3
//        prefix[5] = 4*5 -1 -2 -3 -4; prefix[4]+4;
//        prefix[6] = 4*6 -1 -2 -3 -4; prefix[5]+4;
//        prefix[7] = 4*7 -1 -2 -3 -4; prefix[6]+4;
//        prefix[8] = 4*8 -1 -2 -3 -4; prefix[7]+4;
//        prefix[9] = 4*9 -1 -2 -3 -4; prefix[8]+4; 8 7 6 5
//        prefix[10] = 5*10 -1 -2 -3 -4 -10; 9 8 7 6 0 prefix[9]+4
//        prefix[11] = 5*11 -1 -2 -3 -4 -10; prefix[10]+5
        int idx = 0;
        for(int i=0; i<1000001; i++){
            if(i!=0) prefix[i] = prefix[i-1] + idx;

            while(idx<N && barns[idx]==i) idx++;
        }


//        suffix[11] = 0 - 0*11; 0
//        suffix[10] = 0 - 0*10; 0
//        suffix[9] = 10 - 1*9; 10 -9 suffix[10] +1
//        suffix[8] = 10 - 1*8; 10 -8 suffix[9] +1
//        suffix[7] = 10 - 1*7; 10 -7 suffix[8] +1
//        suffix[6] = 10 - 1*6; 10 -6 suffix[7] +1
//        suffix[5] = 10 - 1*5; 10 -5 suffix[6] +1
//        suffix[4] = 10 - 1*4; 10 -4 suffix[5] +1
//        suffix[3] = 10 + 4 -2*3; 10 + 4 -3 -3  suffix[4] +2
//        suffix[2] = 10 + 4 + 3 - 3*2; 10 + 4 + 3 -2 -2 -2 suffix[3] +3
//        suffix[1] = 10 + 4 + 3 + 2 - 4*1; 10 4 3 2 -1 -1 -1 -1 suffix[2] +4
//        suffix[0] = 10 + 4 + 3 + 2 +1 - 5*0; suffix[1] +5
        int idx2 = N-1;
        for(int i=1000000; i>=0; i--){
            suffix[i] = suffix[i+1] + N - idx2 -1;

            while(idx2>=0 && barns[idx2]==i) idx2--;
        }


        Q = Integer.parseInt(br.readLine());
        while(Q-->0){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            sb.append(binarySearch(0, 1000000)+"\n");
        }


        System.out.println(sb);
    }
}