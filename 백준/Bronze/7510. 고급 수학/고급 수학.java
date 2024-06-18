import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        for(int i=1;i<=n;i++){
            int a=s.nextInt();
            int b=s.nextInt();
            int c=s.nextInt();
            int sum=a*a+b*b+c*c;
            int ma=Math.max(a,Math.max(b,c));
            if(sum==2*ma*ma){
                System.out.format("Scenario #%d:\n",i);
                System.out.println("yes");
            }
            else{
                System.out.format("Scenario #%d:\n",i);
                System.out.println("no");
            }
            System.out.println();
        }
    }
}