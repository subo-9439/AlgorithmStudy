import java.util.ArrayList;
import java.util.List;

class Word{
    int count;
    String word;

    public Word(int count, String word){
        this.count = count;
        this.word = word;
    }
}

class Solution {
     public int solution(String s) {
        int answer = 1000;
        String tempAns = "";
        String subStr = "";

        for (int i = 1; i <= s.length(); i ++) {
            List<Word> list = new ArrayList<>();
            for (int j = 0; j <= s.length() - i; j = j + i) {
                subStr = s.substring(j, j + i);
                // 만약 이 문자열(substring)이 리스트의 맨 마지막 문자와 같다면 count를 증가시킴
                if (list.isEmpty()) {
                    list.add(new Word(1, subStr));
                }
                else{
                    if (list.get(list.size() - 1).word.equals(subStr)){
                        list.get(list.size() - 1).count += 1;
                    }
                    else {
                        list.add(new Word(1, subStr));
                    }
                }
            }

            tempAns = "";
            for (Word w : list){
                if (w.count == 1) tempAns += w.word;
                else {
                    tempAns += w.count;
                    tempAns += w.word;
                }
            }

            // 압축되지 못한 것 더해주기
            if (s.length() % i > 0){
                tempAns += s.substring(s.length() - (s.length() % i) - 1, s.length() - 1);
            }
            
            // 최소값 갱신
            if (answer > tempAns.length()) answer = tempAns.length();
        }

        return answer;
    }
}