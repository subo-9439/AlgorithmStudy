# 방 번호 입력받기
room_number = input()
# 각 숫자 당 몇 회 사용되었는지 저장할 배열 선언
plastic = [0] * 10

# 방 번호의 길이만큼 for문 실행
for i in range(len(room_number)):
    # 방 번호의 숫자 하나하나
    num = int(room_number[i])
    # 방 번호의 숫자가 6이나 9일때
    if num == 6 or num == 9:
        # 여태까지 방 번호의 숫자가 6인 경우가 9인 경우보다 많았으면
        if plastic[6] >= plastic[9]:
            # 9인 경우 하나 늘림
            plastic[9] += 1
        else:
            plastic[6] += 1
    # 방 번호의 숫자가 사용된 만큼 더해줌
    else:
        plastic[num] += 1

# 숫자 중 가장 많은 횟수로 사용된 숫자의 횟수가 정답    
print(max(plastic))