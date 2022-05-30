from itertools import permutations

n = input()
count = 0

# 소수인지 판별하는 함수 is_prime 구현
def is_prime(n):
    if n <= 1:
        return False

    for i in range(2, n):
        if n % i == 0:
            return False
    return True

# 문자열 숫자의 조합을 담을 리스트 생성
num_list = []

# 길이 1부터 입력받은 문자열의 길이만큼 조합을 이용하여 숫자를 생성하고 num_list 배열에 담음
for i in range(1, len(n) + 1):
    num_list += list(permutations(n, i))

# num_list 배열에서 숫자를 띄어쓰기 없이 숫자로 생성해서 새로운 배열인 new_num_list에 담음
# set()을 사용해서 중복을 제거
new_num_list = set(list(int(''.join(num)) for num in num_list))

# new_num_list에 담긴 숫자들을 모두 확인하면서 해당 숫자가 소수라면 count를 1 증가시킴
for new_num in new_num_list:
    if is_prime(new_num):
        count += 1

# count 출력
print(count)