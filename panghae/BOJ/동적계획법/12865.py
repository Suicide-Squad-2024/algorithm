import sys

read = sys.stdin.readline

N, K = map(int, read().rstrip().split())

wv = [(0, 0)]

for _ in range(N):
    wv.append(tuple(map(int, read().rstrip().split())))

dp = [[0] * (N + 1) for _ in range(K + 1)]

for i in range(1, K + 1):
    for j in range(1, N + 1):
        w, v = wv[j]
        if i < w:
            dp[i][j] = dp[i][j - 1]
        else:
            dp[i][j] = max(dp[i][j - 1], dp[i - w][j - 1] + v)

print(dp[K][N])
