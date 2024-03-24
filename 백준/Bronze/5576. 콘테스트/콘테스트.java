import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {

        int res = play();
        int res2 = play();

        System.out.println(res + " " + res2);
    }

    private static int play() throws Exception {
        Integer[] arr = new Integer[10];
        for(int i = 0 ; i < 10 ; i ++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());

        int sum = 0;
        for(int i = 0 ; i < 3 ; i ++)
            sum += arr[i];

        return sum;
    }
}