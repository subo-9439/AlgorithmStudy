import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        StringTokenizer trees = new StringTokenizer(sc.nextLine(), " ");

        /*
        1. trees를 List에 담아 reverseSorting 한다.
        2. 큰 수부터 꺼내서 연산할 거다. 다음 수가 존재할 때 까지.
            1 고려할 점:
                1. 나무가 1그루면 어떻게 범위를 추정? 하나를 꺼내고 나서 다음 높이(어디까지 탐색할지)를 찾을 수 없는게 문제니까, 다음 높이를 0으로 지정.
            2. 연산에 고려할 값: 변수가 될 수도 있고 아닐 수도 있고.
                1. 현재까지 꺼낸 숫자의 갯수(벌목 중인 나무 그루 수)
                2. (현재 높이 - 다음 높이)
                3. 연산한 결과(숫자)
            3. 하려는 연산 1: 범위 추정
                1. '(현재 높이 - 다음 높이) * 현재까지 꺼낸 갯수'를 연산결과와 더한다(+=).
                2. '연산한 결과가 m보다 크거나 같아진 순간'
                    -> (현재 높이 ~ 다음 높이) 사이에서 높이h를 결정하면 된다.
            4. 하려는 연산 2: 범위 특정
                1. '2.3.2.'에서 추정된 범위에서 높이를 1씩 줄여가며 m값을 만족하는 적절한 높이h를 구한다.
        */

        // 1. 담고 정렬
        List<Integer> list = new LinkedList<>();
        while (trees.hasMoreTokens()) list.add(Integer.valueOf(trees.nextToken()));
        Collections.sort(list, Collections.reverseOrder());

        // 2.3. 범위 추정
        int count = 0;          // 2.2.1.
        Integer nowHeight = -1; // 2.2.2. 현재 높이
        Integer nextHeight = -1;// 2.2.2. 다음 높이
        long calc = 0L;           // 2.2.3. 연산한 결과
        while (!list.isEmpty()) {
            nowHeight = list.remove(0);
            count++;
            if (list.isEmpty()) nextHeight = 0; // 2.1.1
            else nextHeight = list.get(0);

            calc += nowTreeLength(count, nowHeight, nextHeight); // 이번 나무 길이

            if (m <= calc) break;
        }

        calc -= nowTreeLength(count, nowHeight, nextHeight); // 범위를 특정하기 위한 준비: 마지막 더한 지점까지(그 이전부터) 볼 거니까, 마지막 더한 내용은 빼준다

        // 2.4. 범위 특정
        int height = nowHeight - 1;
        while (nextHeight <= height) {
            calc += count;

            if (m <= calc) break;

            height--;
        }

        System.out.println(height);
    }

    private static long nowTreeLength(int count, Integer nowHeight, Integer nextHeight) { // 2.3.1.
        return (nowHeight - nextHeight) * count;
    }
    // 삽질 30분 포함 60분 : 근데 통과 안됨
    // 추가 삽질 30분
}