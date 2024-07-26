import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int[] students;
    static boolean[] visited;
    static int number = 0;
    static int bosung;
    static boolean check = true;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        bosung = Integer.parseInt(input[1]);
        students = new int[n];
        for (int i = 0; i < n; i++) {
            students[i] = Integer.parseInt(br.readLine());
        }
        visited = new boolean[students.length];

        dfs(0);

        if (check) {
            bw.write(number + "\n");
        } else {
            bw.write(-1 + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private void dfs(int index) {
        if (visited[index]) {
            check = false;
            return;
        } else {
            visited[index] = true;
            if (index != bosung) {
                dfs(students[index]);
                number++;
            } else {
                return;
            }
        }
    }
}