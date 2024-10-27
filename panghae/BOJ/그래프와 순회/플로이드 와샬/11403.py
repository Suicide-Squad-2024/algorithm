import sys, math

read = sys.stdin.readline

N = int(read().rstrip())

dp = [[math.inf] * (N + 1) for _ in range(N + 1)]

for i in range(N):
    row = list(map(int, read().rstrip().split()))
    for j, value in enumerate(row):
        if value == 1:
            dp[i + 1][j + 1] = 1

for k in range(1, N + 1):
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j])

for i in range(1, N + 1):
    result = []
    for j in range(1, N + 1):
        if dp[i][j] is not math.inf:
            result.append(1)
        else:
            result.append(0)
    print(*result)
