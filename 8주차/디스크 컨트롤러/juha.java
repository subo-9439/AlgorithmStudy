import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int time = 0;
        int index = 0;
        int requestToEnd = 0;
        while(index < jobs.length || !priorityQueue.isEmpty()){
            while(index < jobs.length && jobs[index][0] <= time){
                priorityQueue.add(jobs[index++]);
            }
            if(!priorityQueue.isEmpty() && priorityQueue.peek()[0] <= time){
                int[] deleted = priorityQueue.poll();
                time += deleted[1];
                requestToEnd += time - deleted[0];
            }else{
                time++;
            }
        }
        return requestToEnd / jobs.length;
    }
}