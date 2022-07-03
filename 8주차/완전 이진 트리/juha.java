import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static int[] arr;
    static ArrayList<Integer>[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        arr = new int[(int) Math.pow(2,K) - 1];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(input[i]);

        ans = new ArrayList[K];
        for(int i = 0; i < K; i++)
            ans[i] = new ArrayList<>();

        solve(0, arr.length - 1, 0);

        for(ArrayList<Integer> list : ans) {
            for(int i = 0; i < list.size(); i++){
                System.out.print(list.get(i));
                if(i != list.size() - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void solve(int start, int end, int floor) {
        if(floor == K)
            return;

        int middle = (start + end) / 2;
        ans[floor].add(arr[middle]);

        solve(start,middle - 1, floor + 1);
        solve(middle+1, end, floor + 1);
    }
}