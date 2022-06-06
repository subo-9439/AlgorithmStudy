from itertools import combinations

n, s = map(int, input().split())
count = 0
num_list = list(map(int, input().split()))

for i in range(1, n + 1):
    com_list = list(combinations(num_list, i))
    for j in range(len(com_list)):
        if(sum(com_list[j])== s):
            count += 1

print(count)