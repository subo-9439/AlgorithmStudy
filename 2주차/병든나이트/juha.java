import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        System.out.println(solve(N,M));
    }

    static int solve(int N, int M){
        if(N==1) return 1;
        if(N==2) return Math.min(4, (M+1)/2);
        if(M<7) return Math.min(4, M);
        return M-2;
    }
}
