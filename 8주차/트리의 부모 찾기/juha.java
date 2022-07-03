import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> list;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        int[] parents = new int[N+1];
        for(int i = 0; i <= N+1; i++){
            list.add(new ArrayList<Integer>());
        }
        for(int i = 2; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list.get(first).add(second);
            list.get(second).add(first);
        }

        BFS(1,parents);

        for(int i = 2; i <= N; i++)
            System.out.println(parents[i]);
    }

    private static void BFS(int start, int[] parents) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        parents[start] = 1;

        while(!queue.isEmpty()){
            int parent = queue.poll();

            for(int item : list.get(parent)){
                if(parents[item] == 0){
                    parents[item] = parent;
                    queue.add(item);
                }
            }
        }
    }
}