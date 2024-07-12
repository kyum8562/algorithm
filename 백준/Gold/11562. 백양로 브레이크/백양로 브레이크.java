import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		long[][] map=new long[n+1][n+1];
		for(int i=1;i<=n;i++)
		{
			Arrays.fill(map[i], Integer.MAX_VALUE);
		}
		for(int i=0;i<m;i++)
		{
			s=br.readLine().split(" ");
			int u=Integer.parseInt(s[0]);
			int v=Integer.parseInt(s[1]);
			int b=Integer.parseInt(s[2]);
			if(b==0)//단방향
			{
				map[u][v]=0;
				map[v][u]=1;//v에서 u로 가려면 u에서 v로가는 일방통행 도로 1개를 양방향으로 바꿔줘야한다 
			}
			else//양방향
			{
				map[u][v]=0;
				map[v][u]=0;
			}
		}
		for(int i=1;i<=n;i++)//i번에서 i번으로는 도로를 바꿀 필요가 없으므로 0
		{	
			map[i][i]=0;
		}
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				for(int k=1;k<=n;k++)
				{
					long temp=map[j][i]+map[i][k];
					map[j][k]=Math.min(map[j][k], temp);
				}
			}
		}
		int k=Integer.parseInt(br.readLine());
		StringBuilder result=new StringBuilder();
		for(int i=0;i<k;i++)
		{
			s=br.readLine().split(" ");
			int S=Integer.parseInt(s[0]);
			int E=Integer.parseInt(s[1]);
			result.append(map[S][E]+"\n");
		}
		System.out.println(result.toString());
	}
}