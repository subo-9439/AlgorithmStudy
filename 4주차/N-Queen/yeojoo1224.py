n = int(input())
answer = 0
a, b, c = [False] * n, [False] * (2 * n - 1), [False] * (2 * n - 1)

def dfs_queen(i):
    global answer
    if i == n:
        answer += 1
        return
    for j in range(n):
        if (not a[j] and not b[i + j] and not c[i - j + n - 1]) :
            a[j] = b[i + j] = c[i - j + n - 1] = True
            dfs_queen(i+1)
            a[j] = b[i + j] = c[i - j + n - 1] = False

dfs_queen(0)
print(answer)