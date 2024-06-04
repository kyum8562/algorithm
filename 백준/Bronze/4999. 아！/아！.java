import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.println(compare(str1, str2));
    }

    public static String compare(String str1, String str2) {
        int x = 0;
        int y = 0;

        for (int a=0; a<str1.length(); a++) {
            if (str1.charAt(a) == 'a') x++;
            else if (str1.charAt(a) == 'h') break;
        }

        for (int a=0; a<str2.length(); a++) {
            if (str2.charAt(a) == 'a') y++;
            else if (str2.charAt(a) == 'h') break;
        }

        return x >= y ? "go" : "no";
    }
}