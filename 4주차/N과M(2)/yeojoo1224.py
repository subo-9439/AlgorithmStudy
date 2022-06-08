from itertools import combinations

n, m = map(int, input().split())
num_list = [i for i in range(1, n + 1)]

com_list = list(combinations(num_list, m))

for i in range(len(com_list)):
    print(*com_list[i])