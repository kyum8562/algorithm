import java.util.*;
 
public class Main {
    
    static boolean[][] visited = new boolean[1001][1001];
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int s = scan.nextInt();
        
        bfs(s);
    }
    
    public static void bfs(int s) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 1, 0));
        visited[0][1] = true; 
        
        while(!q.isEmpty()) {
            Node current = q.poll();
            
            if(current.total == s) {
                System.out.println(current.time);
                return;
            }
            
            q.offer(new Node(current.total, current.total, current.time + 1)); 
            
            
            if(current.clipboard != 0 && current.total + current.clipboard <= s && !visited[current.clipboard][current.total + current.clipboard]) {
                q.offer(new Node(current.clipboard, current.total + current.clipboard, current.time + 1));
                visited[current.clipboard][current.total + current.clipboard] = true;
            }
            
            if(current.total >= 1 && !visited[current.clipboard][current.total - 1]) {
                q.offer(new Node(current.clipboard, current.total - 1, current.time + 1));
                visited[current.clipboard][current.total - 1] = true;
            }
        }
    }
    
    public static class Node {
        int clipboard;
        int total;
        int time;
        
        public Node(int clipboard, int total, int time) {
            this.clipboard = clipboard;
            this.total = total;
            this.time = time;
        }
    }
}
