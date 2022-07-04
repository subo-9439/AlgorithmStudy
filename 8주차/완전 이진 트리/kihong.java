import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] arr;
    static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k=Integer.parseInt(st.nextToken());
        arr=new int[(int)Math.pow(2,k)-1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<Math.pow(2,k)-1; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        for(int i =0; i<=k; i++){
            lists.add(new ArrayList<>());
        }
        addNode(1,0,arr.length-1);
        for(int i = 1; i<lists.size(); i++){
            bw.write(String.valueOf(lists.get(i).get(0)));
            for(int j = 1; j<lists.get(i).size(); j++){
                bw.write(" "+lists.get(i).get(j));
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    public static void addNode(int depth,int start, int end){
        if(start==end){
            lists.get(depth).add(arr[start]);
            return;
        }
        int idx = (end+start)/2;
        lists.get(depth).add(arr[idx]);
        addNode(depth+1,start,idx-1);
        addNode(depth+1,idx+1,end);
    }
}