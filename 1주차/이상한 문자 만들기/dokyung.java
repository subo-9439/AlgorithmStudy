class dokyung {
    public String solution(String s) {
        String answer = "";
        String[] split = s.split(" ",-1);

        for (int i = 0; i < split.length; i++) {
            for (int j = 0; j < split[i].length(); j++) {
                if (j % 2 == 0) {
                    answer += Character.toUpperCase(split[i].charAt(j));
                    continue;
                }
                answer += Character.toLowerCase(split[i].charAt(j));
            }
            answer += " ";
        }

        return answer.substring(0, answer.length() - 1);
    }
}