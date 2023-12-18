import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if(s.equals("NLCS")) System.out.println("North London Collegiate School");
        else if(s.equals("BHA")) System.out.println("Branksome Hall Asia");
        else if(s.equals("KIS")) System.out.println("Korea International School");
        else System.out.println("St. Johnsbury Academy");
    }
}