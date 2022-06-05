import java.util.*;

public class Main {
    public static int[] arr;
    public static int N;
    public static int count = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];

        nQueen(0);
        System.out.println(count);
    }

    private static void nQueen(int x) {
        if(x == N){
            count++;
            return;
        }
        for(int i = 0; i<N; i++){
            arr[x] = i;
            if(check(x))
                nQueen(x+1);
        }
    }

    private static boolean check(int level) {
        for(int  i = 0; i < level; i++){
            if(arr[i] == arr[level] || Math.abs(arr[level] - arr[i]) == level - i)
                return false;
        }
        return true;
    }
}
