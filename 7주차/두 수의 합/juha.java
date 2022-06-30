import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] seq = new int[n];
        for(int i = 0; i < n; i++){
            seq[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        Arrays.sort(seq);
        int cnt = 0;
        int left = 0;
        int right = n-1;
        while(left < right){
            if(seq[left]+seq[right] == x){
                cnt++;
                left++;
                right--;
            }
            else if(seq[left]+seq[right] < x){
                left++;
            }
            else{
                right--;
            }
        }
        System.out.println(cnt);
    }
}