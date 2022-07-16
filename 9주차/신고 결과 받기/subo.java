import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//최적화 하는 방법이 기억이 안남..

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        //신고 기록 초기화
        HashMap<String, Set<String>> reportMap = new HashMap<>();
        HashMap<String, Integer> answerMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            reportMap.put(id_list[i],new HashSet<>());
            answerMap.put(id_list[i],0);
        }

        //리포트 기록 담기
        for (int i = 0 ; i < report.length; i++){
            StringTokenizer st = new StringTokenizer(report[i] , " ");
            String from = st.nextToken();
            String to = st.nextToken();

            //HashSet에 새로 넣을 수 있다면
            //신고누적 기록
            if (reportMap.get(from).add(to)){
                answerMap.put(to,answerMap.get(to)+1);
            }
        }

        //고소 당해야할 사람들 찾기
        for (String a : answerMap.keySet()){
            if (answerMap.get(a) >= k){//신고 누적횟수를 넘겼기 떄문에
                for (int i = 0; i < id_list.length; i++){//용감한 시민 찾기
                    if (reportMap.get(id_list[i]).contains(a)){//id_list[i]가 신고한적있다면 answer[i]++;
                        answer[i]++;
                    }
                }
            }
        }
        return answer;
    }

}