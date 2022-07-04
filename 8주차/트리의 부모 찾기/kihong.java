import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] bumo;
    static boolean[] used;
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        bumo = new int[n+1];
        used = new boolean[n+1];
        int one;
        int two;
        for(int i = 0; i<n+1; i++){
            list.add(new ArrayList<Integer>());
        }
        for(int i = 1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            one = Integer.parseInt(st.nextToken());
            two = Integer.parseInt(st.nextToken());
            list.get(one).add(two);
            list.get(two).add(one);
        }
        queue.add(1);
        used[1]=true;
        int num;
        int inner;
        while(!queue.isEmpty()){
            num = queue.poll();
            for(int i = 0; i<list.get(num).size(); i++){
                inner = list.get(num).get(i);
                if(!used[inner]){
                    bumo[inner]=num;
                    queue.add(inner);
                    used[inner]=true;
                }
            }
        }
        for(int i =2; i<n+1; i++){
            bw.write(String.valueOf(bumo[i]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

}