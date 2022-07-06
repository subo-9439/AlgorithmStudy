import java.util.*;
class Solution {

    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = stopedId(id_list,report,k);

        return answer;
    }
    public int[] stopedId(String[] id_list, String[] report, int k){
        //모든 것을 인덱스로 처리할 수 있도록 만들어야 함
        for(int i =0; i<id_list.length; i++){
            list.add(new ArrayList<>());
        }
        ArrayList<HashSet<String>> reported = reportId(id_list,report);
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i<id_list.length; i++){
            map.put(id_list[i],0);
        }
        for(int i =0; i<id_list.length; i++){
            for(int j =0; j<id_list.length; j++){
                if(reported.get(i).contains(id_list[j])){
                    map.put(id_list[j],map.get(id_list[j])+1);
                }
            }
        }
        int[] result = new int[id_list.length];
        for(int i = 0; i<id_list.length; i++){
            if(map.get(id_list[i])>=k){
                for(int j=0; j<id_list.length; j++){
                    if(reported.get(j).contains(id_list[i])){
                        result[j]++;
                    }
                }
            }
        }
        return result;
    }
    public ArrayList<HashSet<String>> reportId (String[] id_list, String[] report){
        ArrayList<HashSet<String>> reported = new ArrayList<>();
        for(int i = 0; i<id_list.length; i++){
            reported.add(new HashSet<>());
        }

        String[] names;
        for(int i=0; i<report.length; i++){
            names = report[i].split(" ");
            for(int j=0; j<id_list.length; j++){
                if(names[0].equals(id_list[j])){
                    reported.get(j).add(names[1]);
                }
            }
        }

        return reported;
    }
}