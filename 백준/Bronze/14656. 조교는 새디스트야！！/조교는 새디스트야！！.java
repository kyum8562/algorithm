import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int count=0;
        for(int i=1;i<=n;i++){
            int a=s.nextInt();
            if(a!=i) count++;
        }
        System.out.print(count);
    }
}