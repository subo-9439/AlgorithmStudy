import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int len, limit;
    static StringBuilder sb = new StringBuilder();

    // 재귀함수로 순열을 탐색
    public static void permutation(ArrayList<Integer> nums, int now){
        // 길이가 차면 스트링 빌더에 추가
        if (nums.size() == len){
            for (int i = 0; i < nums.size(); i++){
                sb.append(nums.get(i) + 1).append(" ");
            }
            sb.append("\n");
        }

        for (int i = now; i < limit; i++){
            nums.add(i);
            permutation(nums, i + 1);
            nums.remove(nums.size()-1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        limit = Integer.parseInt(nm[0]); // n
        len = Integer.parseInt(nm[1]); // m

        permutation(new ArrayList<Integer>(), 0);
        System.out.println(sb.toString());

    }
}
