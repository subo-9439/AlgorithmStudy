import java.util.*;

public class Main {
    static ArrayList<Integer> dfs_list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 정점의 개수 N
        int M = sc.nextInt();   // 간선의 개수 M
        int V = sc.nextInt();   // 탐색을 시작할 정점의 번호 V
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[N+1];
        ArrayList<Integer> output = new ArrayList<>();
        for(int i = 0; i<=N; i++){
            list.add(new ArrayList<Integer>());
        }
        for(int i = 0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for(int i = 0; i<=N; i++){
            Collections.sort(list.get(i));
        }
        dfs_list = new ArrayList<>();
        visited[V] = true;
        dfs_list.add(V);
        DFS(list,output,visited,V,1);
        String answer = "";
        for(int i = 0; i<dfs_list.size(); i++){
            answer += dfs_list.get(i) + " ";
        }
        System.out.println(answer.substring(0, answer.length()-1));
        System.out.println(BFS(list, V));
    }

    private static void DFS(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> output, boolean[] visited, int v, int depth) {
        if(list.get(v).size() == 0){
            return;
        }
        for(int i = 0; i<list.get(v).size(); i++){
            int tmp_value = list.get(v).get(i);
            if(!visited[tmp_value]){
                visited[tmp_value] = true;
                dfs_list.add(tmp_value);
                DFS(list, output, visited, tmp_value, depth+1);
                visited[tmp_value] = true;
            }
        }
    }

    private static String BFS(ArrayList<ArrayList<Integer>> list, int v) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> done = new ArrayList<>();
        q.add(v);
        while(!q.isEmpty()){
            int value = q.poll();
            for(int i = 0; i<list.get(value).size(); i++){
                int tmp_value = list.get(value).get(i);
                if(!q.contains(tmp_value) && !done.contains(tmp_value) && tmp_value != value)
                    q.add(tmp_value);
            }
            done.add(value);
        }
        String answer = "";

        for(int i = 0; i<done.size(); i++){
            answer += done.get(i) + " ";
        }

        return answer.substring(0, answer.length() - 1);
    }
}