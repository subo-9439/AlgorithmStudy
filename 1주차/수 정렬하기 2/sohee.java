import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> numList = new ArrayList<>();

        for (int i = 0; i < n; i++){
            numList.add(Integer.parseInt(br.readLine()));
        }
        //Arrays.sort(numList); // dual-pivot Quicksort, 시간초과 -> 최악의 경우 시간복잡도 O(n^2)
        Collections.sort(numList); // 합병 및 삽입정렬 알고리즘, O(n)~O(nlogn) 보장, 원시타입 불가

        StringBuilder ans = new StringBuilder(); // 그냥 각각 출력하면 시간초과
        for (int num : numList){
            ans.append(num).append('\n');
        }
        System.out.println(ans);
    }
}
