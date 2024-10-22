import sys

read = sys.stdin.readline

n = int(read().rstrip())

stairs = [0] * 301

dp = [0] * 301

for i in range(1, n + 1):
    stairs[i] = int(read().rstrip())

dp[1] = stairs[1]
dp[2] = max(dp[1] + stairs[2], stairs[2])

for i in range(3, n + 1):
    dp[i] = max(dp[i - 3] + stairs[i - 1], dp[i - 2]) + stairs[i]

print(dp[n])
