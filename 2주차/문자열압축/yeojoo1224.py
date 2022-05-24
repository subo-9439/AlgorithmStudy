def solutions(s):
    answer = len(s)
    # 압축 단위를 늘려나가며 확인
    for i in range(1, len(s) // 2 + 1):
        comp = ""
        # 문자열의 맨 앞부터 i만큼의 문자열을 unit단위로 만든다.
        unit = s[0:i]
        count = 1
        # i만큼 증가시키며 이전 문자열과 비교
        for j in range(i, len(s)):
            # 이전 unit과 다음 문자열 unit이 동일하다면 압축 횟수 증가
            if unit == s[j:j + i]:
                count += 1
            # 이전 unit과 다음 문자열 unit이 다르면
            else:
                comp += str(count) + unit if count >= 2 else unit
                # 다시 상태를 초기화
                unit = s[j:j + i]
                count = 1

        # 남아 있는 문자열 처리
        comp += str(count) + unit if count >= 2 else unit
        # 만들어지는 압축 문자열이 가장 작은 경우를 정답으로 리턴
        answer = min(answer, len(comp))
    
    return answer