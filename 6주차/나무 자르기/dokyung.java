import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dokyung {
    static int N,M;
    static long cutSum;

    static long[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = (Long.parseLong(st.nextToken()));
        }

        // 큰값
        long max = Arrays.stream(list).max().getAsLong();
        // 중간값
        long center = max/2;
        // 최소값 : 0이아닌 배열의 최솟값을 하면 답이 0인경우를 찾을 수 없다.
        long min = 0;

        JG(min,center,max);

        /**
         * 문제 다시설명
         * N개의 수로 이루어진 배열의 각 수에 특정 수를 뺀 후의 합이 M과 같거나 약간 커야한다.
         * 빼는 수가 뺄 수 보다 더 크면 무시
         *
         * 이분탐색을 적용한다면?
         * 뺄 수 있는 수의 범위는 0부터 가장 큰 숫자까지
         * 중간값을 계산해서 뺌 -> 계산한 값이 M보다 크다? = 중간값에 중간값/2를 더한 뒤 다시 계산
         *                 -> 계산한 값이 M보다 작다? = 중간값을 다시 반으로 나눈 뒤 계산
         */
    }

    public static void JG(long min,long center, long max){
        if (min>max){
            System.out.println(center);
            return;
        }

        //합 초기화
        cutSum=0;

        //합 구하기
        for (int i = 0; i < N; i++) {
            if(list[i]>center) cutSum+= list[i]-center;
        }

        //합이 M보다 크거나 같으면?
        //더 크게 잘라야한다
        if(cutSum>=M){
            //하한값 증가
            min = center + 1;
            center = (min+max)/2;
        }
        //합이 M보다 작으면 더 작게 잘라야한다
        else{
            //상한값 감소
            max = center - 1;
            center = (min+max)/2;
        }
        JG(min,center,max);
    }
}

