import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        System.out.println(s.replace("pi", " ").replace("ka", " ").replace("chu", " ").replace(" ", "").isEmpty() ? "YES" : "NO");
    }
}