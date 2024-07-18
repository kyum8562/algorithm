import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int arr[] = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i= 0;i<M;i++){
                arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);   
        int range = (int)(arr[0]- 0.5 + L);
        int count = 1;
     
        for(int i=1;i<arr.length;i++){
            if(range <(int)(arr[i]+0.5)){
                range = (int)(arr[i]-0.5 + L);
                count++;
            }
        }

        System.out.println(count);
    }
}