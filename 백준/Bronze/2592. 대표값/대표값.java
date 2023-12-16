import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //평균이랑 최빈값
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int[] arr = new int [1001];
        for(int i=0;i<10;i++){
            int elem = sc.nextInt();
            sum+=elem;
            arr[elem]++;
            
        }

        int index = 0;
        int max = 0;
        for(int i=0;i<1001;i++){
            if(max<arr[i]){
                max=arr[i];
                index = i;
            }
        }

        System.out.print((sum/10)+"\n"+index);

    }
}