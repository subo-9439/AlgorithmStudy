import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        boolean[] visited = new boolean[N];

        permutation(visited,0,N,M);
    }

    private static void permutation(boolean[] visited, int start, int n, int r) {
        if(r == 0){
            print(visited, n);
            return;
        }

        for(int i = start; i<n; i++){
                visited[i] = true;
                permutation(visited, i+1, n, r-1);
                visited[i] = false;
        }
    }

    private static void print(boolean[] visited, int n) {
        boolean start = true;
        for(int i = 0; i<n; i++){
            if(visited[i]){
                if(start){
                    System.out.print((i+1));
                    start = false;
                }
                else
                    System.out.print(" "+(i+1));
            }
        }
        System.out.println();
    }
}
