import sys

read = sys.stdin.readline

N = int(read().rstrip())

cost = []

for i in range(N):
    cost.append(list(map(int, read().rstrip().split())))

dp = [[0, 0, 0] for _ in range(N+1)]

dp[1][0] = cost[0][0]
dp[1][1] = cost[0][1]
dp[1][2] = cost[0][2]

for i in range(2, N+1):
    dp[i][0] = cost[i-1][0] + min(dp[i-1][1], dp[i-1][2])
    dp[i][1] = cost[i-1][1] + min(dp[i - 1][0], dp[i - 1][2])
    dp[i][2] = cost[i-1][2] + min(dp[i - 1][1], dp[i - 1][0])

print(min(dp[N]))