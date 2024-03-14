import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());
        nums=new int[n+1];

        int size=(int)Math.ceil((Math.log(n)/Math.log(2)));
        tree=new long[(int)Math.pow(2,size+1)];
        lazy=new long[(int)Math.pow(2,size+1)];

        st=new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            for(int i=1;i<n+1;i++){
                nums[i]=Integer.parseInt(st.nextToken());
            }
        }

        init(1,n,1);
        int m=Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int q=Integer.parseInt(st.nextToken());
            if(q==1){
                int l=Integer.parseInt(st.nextToken());
                int r=Integer.parseInt(st.nextToken());
                int k=Integer.parseInt(st.nextToken());
                update(1,n,l,r,1,k);
            }
            else{
                int x=Integer.parseInt(st.nextToken());
                query(1,n,x,1);
            }
        }

    }
    
    static int[] nums;
    static long[] tree,lazy;
    static int n;

    static void init(int s,int e,int node){
        if(s==e){
            tree[node]=nums[s];
            return;
        }


        int mid=(s+e)>>1;
        init(s,mid,node*2);
        init(mid+1,e,node*2+1);
        tree[node]=tree[node*2]+tree[node*2+1];
    }

    static void update_lazy(int s,int e,int node){
        if(lazy[node]!=0){
            tree[node]+=(e-s+1)*lazy[node];
            if(s!=e){
                lazy[node*2]+=lazy[node];
                lazy[node*2+1]+=lazy[node];
            }
            lazy[node]=0;
        }
    }

    static void query(int s,int e,int idx,int node){
        update_lazy(s,e,node);
        if(idx<s || e<idx) return;
        if(s==e){
            System.out.println(tree[node]);
            return;
        }

        int mid=(s+e)>>1;
        query(s,mid,idx,node*2);
        query(mid+1,e,idx,node*2+1);
    }

    static void update(int s,int e,int l,int r,int node,int val){
        update_lazy(s,e,node);
        if(r<s || e<l)return;

        if(l<=s && e<=r){
            tree[node]+=val*(e-s+1);
            if(s!=e){
                lazy[node*2]+=val;
                lazy[node*2+1]+=val;
            }
            return;
        }

        int mid=(s+e)>>1;
        update(s,mid,l,r,node*2,val);
        update(mid+1,e,l,r,node*2+1,val);
        tree[node]=tree[node*2]+tree[node*2+1];
    }

}