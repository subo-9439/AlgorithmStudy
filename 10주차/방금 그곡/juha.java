import java.util.ArrayList;

class Solution {
    public String solution(String m, String[] musicinfos) {
        ArrayList<String[]> list = new ArrayList<>();
        // 1.String 값들을 구해서 ArrayList에 넣는다.
        for(String mi : musicinfos){
            String[] musicinfo = mi.split(",");
            // 1-1. 1번째 인덱스 - 0번째 인덱스로 작동시간을 구한다.
            String start = musicinfo[0].replace(":","");
            String end = musicinfo[1].replace(":","");
            int sec = (Integer.parseInt(end)/100 - Integer.parseInt(start)/100) * 60 + (Integer.parseInt(end.substring(2)) - Integer.parseInt(start.substring(2)));
            // 1-2. 노래이름, 노래스트링 값을 ArrayList에 넣는다.
            list.add(new String[]{musicinfo[2],musicinfo[3],Integer.toString(sec)});
        }
        // 2.넣어진 값들과 m을 비교해서 조건이 일치하지 않는 값들을 지운다.
        // 2-1. 예시 3처럼 C와 C#은 어떻게 비교할 것인가? -> 단순한 contains로는 안된다..!!
        for(int listIndex = list.size() -1; listIndex >= 0; listIndex--){
            boolean isContain = false;
            int cnt = 0;
            int time = 0;
            for(int j = 0; j < list.get(listIndex)[1].length(); j++){
                if(list.get(listIndex)[1].length()>Integer.parseInt(list.get(listIndex)[2]) && j > Integer.parseInt(list.get(listIndex)[2]))
                    break;
                // 2-2. 따라서 리스트에 저장되어 있는 곡들을 순서대로 m과 비교해본다.
                if(list.get(listIndex)[1].charAt(j) == m.charAt(0)){
                    // 2-3. 만약 곡의 원소가 m의 첫번째 원소가 같을 경우, 같은 곡인지 비교할 반복문을 실행한다.
                    for(int k = 0; k < m.length(); k++){
                        int index = j+k;
                        if(index >= list.get(listIndex)[1].length())
                            index = (j+k) % list.get(listIndex)[1].length();
                        if(list.get(listIndex)[1].charAt(index) == m.charAt(k)){
                            // 2-4. 원소가 같다면 같은 원소의 개수를 세는 cnt를 증가시킨다.
                            if(m.charAt(k) != '#')
                                time++;
                            cnt++;
                        }else{
                            // 2-5. 원소가 같지 않다면 다른 내용이므로 더 볼 필요가 없다.
                            break;
                        }
                        if(k == m.length() - 1){
                            // 2-6. 맨 마지막 뒤 원소에 혹시 #가 붙어 있는지 아닌지 확인하여 #이 붙어 있다면 같지 않으므로 cnt를 변경한다.
                            if(index+1 < list.get(listIndex)[1].length() &&list.get(listIndex)[1].charAt(index+1) == '#')
                                cnt = -1;
                        }
                    }
                    if(time <= Integer.parseInt(list.get(listIndex)[2]) && cnt == m.length()){
                        // 2-7. 같은 원소의 개수가 m의 길이와 같다는 말은 m 부분이 해당 노래에 존재한다는 뜻이다.
                        isContain = true;
                    }
                    cnt = 0;
                    time = 0;
                }
            }
            if(!isContain){
                list.remove(listIndex);
            }
        }

        if(list.size() == 0){
            // 3.조건이 일치하는 음악이 없을 때는 (None) 을 반환한다.
            return "(None)";
        }else if(list.size() == 1){
            // 4. 조건이 일치하는 음악이 하나라면 해당 음악의 제목을 반환한다.
            return list.get(0)[0];
        }else{
            // 4.만약 조건이 일치하는 음악이 여러개라면 재생시간이 제일 긴 음악 제목을 반환한다.
            int maxmusiclen = list.stream().mapToInt(x -> Integer.parseInt(x[2])).max().getAsInt();
            for(int listIndex = list.size() -1; listIndex >= 0; listIndex--){
                if(Integer.parseInt(list.get(listIndex)[2]) != maxmusiclen)
                    list.remove(listIndex);
            }
            // 5.재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
            int index = 1;
            for(int listIndex = list.size() -1; listIndex > 0; listIndex--){
                list.remove(index++);
            }
            return list.get(0)[0];
        }
    }
}