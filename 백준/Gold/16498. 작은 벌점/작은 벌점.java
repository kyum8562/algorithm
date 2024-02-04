import java.io.*;
import java.util.*;

public class Main {
    static int C;
    static int[] mapC;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int[] mapA = new int[A];
        int[] mapB = new int[B];
        mapC = new int[C];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < A ; i ++)
            mapA[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < B ; i ++)
            mapB[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < C ; i ++)
            mapC[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(mapA);
        Arrays.sort(mapB);
        Arrays.sort(mapC);

        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < A ; i ++){
            int choice1 = mapA[i];
            int choice2 = binarySearch(choice1, mapB);
            int choice3_1 = binarySearch(choice2, mapC);
            int choice3_2 = binarySearch(choice1, mapC);

            int localMax = Math.max(choice1, Math.max(choice2, choice3_1));
            int localMin = Math.min(choice1, Math.min(choice2, choice3_1));
            int localRes = localMax - localMin;

            int localMax2 = Math.max(choice1, Math.max(choice2, choice3_2));
            int localMin2 = Math.min(choice1, Math.min(choice2, choice3_2));
            int localRes2 = localMax2 - localMin2;

            min = Math.min(min, Math.min(localRes, localRes2));
        }

        System.out.println(min);
    }

    private static int binarySearch(int T, int[] map) {
        int s = 0;
        int e = map.length-1;
        int m = 0;

        int nearest = map[e];
        int nearestDist = Math.abs(nearest - T);

        while(e >= s){
            m = (s + e) / 2;
            int cur = map[m];

            if(cur > T) e = m - 1;
            else if(cur < T) s = m + 1;
            else return cur;

            int b = Math.abs(cur - T);
            if(nearestDist > b){
                nearest = cur;
                nearestDist = b;
            }
        }
        return nearest;
    }
}