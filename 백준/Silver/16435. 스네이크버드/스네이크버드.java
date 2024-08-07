import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);	//오름차순 정렬
        //낮은 과일부터 탐색 진행
        for(int i=0;i<N;i++){
            if(L >= arr[i])	//스네이크버드 길이보다 작거나 같으면 과일 섭취
                L++;	//길이 증가
        }
        bw.write(L + "");	//스네이크버드 길이 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
}