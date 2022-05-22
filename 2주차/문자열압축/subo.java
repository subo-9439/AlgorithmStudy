public class subo {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        //1개부터 단어길이의 반까지만(최대 반으로 줄일 수 있으니까)

        //자를 단위는 1부터 단어길이의 반까지
        if(s.length()==1) {
            answer=1;
        }
        for(int unit = 1; unit <s.length(); unit++){
            String newWord = "";
            int cnt = 1;
            //그 단위만큼 단어를 잘랐을때
            String tempWord = s.substring(0,unit);
            //start ,end;
            for(int start = unit; start < s.length(); start+=unit) {

                int end = start + unit;
                //마지막 단어 잘르는부분이 이제 subString 범위 안으로 들어가야하니까
                if(end >= s.length()) end = s.length();
                String curWord = s.substring(start,end);

                if(tempWord.equals(curWord)){//같냐
                    cnt++;

                }else {//다르냐
                    if(cnt == 1) {
                        newWord += tempWord;

                    }
                    else {
                        newWord += cnt + tempWord;
                    }
                    tempWord = curWord;
                    cnt=1;
                }
                
                
                //마지막은 무조건 마지막으로 생각하자 
                if(end == s.length()&& tempWord.equals(curWord)) {
                    if(cnt == 1) newWord +=  curWord;
                    else newWord += cnt + curWord;
                }
                if(end == s.length() && !tempWord.equals(curWord)) newWord += curWord;
            }
            System.out.println(newWord);
            answer = Math.min(answer, newWord.length());
        }
        return answer;
    }
}
