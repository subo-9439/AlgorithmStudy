import java.util.Scanner;

public class dokyung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int count = 0;

        while (N>=2&&M>0&&M+N>K){
            N-=2;
            M--;
            count++;
        }
        if(M+N<K)
            count--;
        System.out.println(count);
    }
}


