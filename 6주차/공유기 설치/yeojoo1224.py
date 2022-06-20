n, c = map(int, input().split())
list = []

for _ in range(n):
    list.append(int(input()))

list.sort()

start = 1
end = list[-1] - list[0]

while start <= end:
    mid = (start + end) // 2
    temp = list[0]
    count = 1

    for i in range(1, n):
        if list[i] >= temp + mid:
            count += 1
            temp = list[i]
    
    if count >= c:
        start = mid + 1
        dist = mid
    
    else:
        end  = mid - 1

print(dist)