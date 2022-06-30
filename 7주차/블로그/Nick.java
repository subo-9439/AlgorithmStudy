import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Nick {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        sc.nextLine();
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int[] arr = new int[n];
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /*
        - 250000 * 8000 = 2,000,000,000
        - for문 안에서 x의 범위로 작은 for를 돌면, o(xn)이 된다. 그걸로 통과가 될까? 모르겠다
        - sum을 구해두고 앞뒤로 하나씩 더하고 빼면서 비교해서 max를 구하면 o(n)이면 될 것 같다. 일단 이렇게 해보도록 한다. - 아 이게 슬라이딩윈도우지 참... 그래서 투포인터였구나..
        */

        Map<Integer, Integer> maxMap = new HashMap<>();
        int sum = 0;
        int max = 0;
        for (int i = 0; i < x; i++) {
            sum += arr[i];
            max = sum;
        }
        calcDays(maxMap, max);

        for (int i = x; i < arr.length; i++) {
            int sumFirst = arr[i - x];
            int sumLast = arr[i];
            int newSum = sum - sumFirst + sumLast;
            if (max <= newSum) {
                max = newSum;
                calcDays(maxMap, max);
            }
            sum = newSum;
        }

        if (max == 0) {
            System.out.println("SAD");
        }
        else {
            System.out.println(max + System.lineSeparator() + maxMap.get(max));
        }

    }
    private static void calcDays(Map<Integer, Integer> maxMap, int max) {
        maxMap.put(max, maxMap.getOrDefault(max, 0) + 1);
    }

}
