import java.io.*;
import java.util.*;
public class Main {
    static int n,k;
    static ArrayList<Node>list = new ArrayList<>();
    static int end_point=0;     // 정렬후 k번째국가의 위치를 알기 위한 것
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]); // 국가의수
        k = Integer.parseInt(t[1]); // 등수를 알고 싶은 국가
        
        for(int i=0; i<n; i++) {
            String[] tt = br.readLine().split(" ");
            int num = Integer.parseInt(tt[0]);      //국가의 번호
            int gold = Integer.parseInt(tt[1]);
            int silver = Integer.parseInt(tt[2]);
            int bronze = Integer.parseInt(tt[3]);
            list.add(new Node(num,gold,silver,bronze,0));
        }
        Collections.sort(list);
        
        list.get(0).rate=1; // 정렬을 했으니 리스트의 첫번째 국가는 무조건 1등이다
        
        for(int i=1; i<list.size(); i++) {
            int tmp_gold= list.get(i-1).gold;
            int tmp_silver = list.get(i-1).silver;
            int tmp_bronze = list.get(i-1).bronze;
            Node now = list.get(i);
            if(list.get(i).num == k) {  // 국가의 번호가 k번이면 end_point를 찾고 마지막 정답 출력 할 때 사용
                end_point=i;
            }
            if(now.gold == tmp_gold && now.silver==tmp_silver && now.bronze==tmp_bronze) {
                list.get(i).rate=list.get(i-1).rate;
            }
            
            else {
                list.get(i).rate = i+1;
            }
        }
        
        System.out.println(list.get(end_point).rate);
    }
}
class Node implements Comparable<Node>{
    int num,gold,silver,bronze,rate;
    Node(int num, int gold, int silver, int bronze, int rate){
        this.num=num;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.rate=rate;
    }
    public int compareTo(Node o) {
        if(this.gold==o.gold) {
            if(this.silver==o.silver) {
                return o.bronze-this.bronze;
            }
            else {
                return o.silver-this.silver;
            }
        }
        else {
            return o.gold-this.gold;
        }
    }
}