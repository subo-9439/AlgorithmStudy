import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int firstNode;
    static int[][] graph;
    static int[] dfsNodes;
    static int[] bfsNodes;
    static boolean[] used;
    static boolean[] dfsWrite;
    static Queue<Integer> queue = new LinkedList<>();
    static int idx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        firstNode = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        dfsNodes=new int[N+1];
        bfsNodes=new int[N+1];
        int node1;
        int node2;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            node1=Integer.parseInt(st.nextToken());
            node2=Integer.parseInt(st.nextToken());
            graph[node1][node2]=1;
            graph[node2][node1]=1;
        }
        idx=1;
        dfsNodes[idx]=firstNode;
        used = new boolean[N+1];
        dfsWrite= new boolean[N+1];
        used[firstNode] = true;
        dfsWrite[firstNode]=true;
        idx++;
        dfs(firstNode);
        String result ="";
        for(int i = 1; i<dfsNodes.length; i++){
            if(dfsNodes[i]!=0) result+=dfsNodes[i]+" ";
        }
        result.trim();
        bw.write(result);
        bw.newLine();
        result="";
        Arrays.fill(used,false);
        queue.add(firstNode);
        used[firstNode]=true;
        result+=firstNode;
        int start;
        while(!queue.isEmpty()){
            start=queue.poll();
            for(int i=1; i<N+1; i++){
                if(!used[i]&&graph[start][i]==1){
                    result+=" "+i;
                    queue.add(i);
                    used[i]=true;
                }
            }
        }
        bw.write(result);
        bw.flush();
        bw.close();
    }
    public static void dfs(int start){
        for(int i =1; i<N+1; i++){
            if(!used[i]&&graph[start][i]==1){
                used[i]=true;
                dfsNodes[idx]=i;
                idx++;
                dfs(i);
            }
            if(idx>N) break;
        }
    }

}
