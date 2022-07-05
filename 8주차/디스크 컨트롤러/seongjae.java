import java.util.Arrays;
import java.util.PriorityQueue;

public class seongjae {
    public static void main(String[] args) {
        int[][] jobs = new int[][]{
                {0, 3},
                {1, 9},
                {2, 6}
        };
        System.out.println(solu(jobs));
    }
    public static int solu(int[][] jobs) {
        int answer = 0;
        int end = 0;    // 수행되고난 직후의 시간
        int jobsIdx = 0; // jobs 배열의 인덱스
        int count = 0; // 수행된 요청 갯수

        // 원본 배열 : 요청시간 오름차순 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        // 처리 시간 기준 오름차순 정렬되는 큐(heap)
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        // 요청이 전부 수행될 때까지 반복
        while (count < jobs.length) {
            // 하나의 작업이 완료되는 시점(end)까지 들어온 모든 요청을 큐에 넣는다.
            while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
                pq.add(jobs[jobsIdx++]);
            }
            // 큐가 비어있다면 작업 완료(end) 후에 다시 요청이 들어오게 한다.
            // -> end를 요청의 가장 처음으로 맞춰준다.
            if(pq.isEmpty()) {
                end = jobs[jobsIdx][0];

                // end 이전 들어온 요청 중 수행시간이 가장 짧은 요청부터 수행한다.
            } else {
                int[] temp = pq.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }
        }
        return (int) Math.floor(answer / jobs.length);
    }
}