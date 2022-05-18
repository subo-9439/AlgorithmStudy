n, m, k = map(int, input().split())
team = 0

# 총 학생 수가 인턴쉽에 참여해야 하는 학생 수 보다 3명 이상이고
# 여학생이 2명 이상, 남학생이 1명 이상일 때
while n + m >= k + 3 and n >= 2 and m >= 1:
    # 여학생 2명과 남학생 1명을 한 팀으로 묶는다
    n -= 2  
    m -= 1
    team += 1

print(team)