import java.util.*;

public class Main {
    static int S;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        S = sc.nextInt();
        int[] nums = new int[N];
        ArrayList<int[]> list = new ArrayList<>();
        boolean[] visited = new boolean[N];
        for(int i = 0; i<N; i++)
            nums[i] = sc.nextInt();
        for(int i = 1; i<=N; i++)
            combination(list, nums, visited, 0, N, i);
        System.out.println(list.stream().count());
    }

    private static void combination(ArrayList<int[]> list, int[] nums, boolean[] visited, int start, int n, int r) {
        if(r == 0){
            int sum = 0;
            int count = 0;
            for(int i = 0; i<visited.length; i++){
                if(visited[i]) {
                    sum += nums[i];
                    count++;
                }
            }
            if(sum == S) {
                int[] tmp = new int[count];
                int t = 0;
                for(int i = 0; i<visited.length; i++){
                    if(visited[i])
                        tmp[t++] = nums[i];
                }
                list.add(tmp);
            }
            return;
        }
        for(int i = start; i<n; i++){
            visited[i] = true;
            combination(list, nums, visited, i+1, n, r-1);
            visited[i] = false;
        }
    }
}
