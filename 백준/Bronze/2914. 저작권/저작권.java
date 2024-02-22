import java.io.*;
import java.util.StringTokenizer;
public class Main {
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int I = Integer.parseInt(st.nextToken());
		bw.write(String.valueOf(A*(I-1)+1));
		bw.flush();
		bw.close();
	}
}