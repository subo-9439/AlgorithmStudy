import java.util.*;

class subo {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Process> pq = new PriorityQueue<>();
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        int idx = 0;
        int now = 0;
        int count = 0;
        int total = 0;
        while (count < jobs.length){    //프로세스를 전부다처리할때 까지
            while (idx < jobs.length && jobs[idx][0] <= now){
                pq.add(new Process(jobs[idx][0],jobs[idx++][1]));//동시에 처리할 수 있는 프로세스 순서 정하기
            }
            if (pq.isEmpty()){
                now++;//now = jobs[idx][0];
            }else {
                Process pro = pq.poll();
                total += pro.requiredTime + now - pro.waitTime;//요청부터 종료시까지 소요시간 다더하기
                now += pro.requiredTime;                //현재 시간은 requiredTime이 더해진다.
                count++;                    //개수 세기
            }

        }
        return answer = total/ jobs.length;
    }
    public class Process implements Comparable<Process>{
        int waitTime;
        int requiredTime;
        public Process(int waitTime, int requiredTime){
            this.waitTime = waitTime;
            this.requiredTime = requiredTime;
        }


        @Override
        public int compareTo(Process o) {
            return this.requiredTime - o.requiredTime;
        }
    }
}