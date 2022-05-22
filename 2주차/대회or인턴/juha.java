import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        while(K>0){
            if(N/2>M){
                N -= 2;
                K -= 2;
            }else{
                M -= 1;
                K -= 1;
            }
        }
        System.out.println(Math.min(N/2,M));
    }
}
