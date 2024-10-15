import sys

read = sys.stdin.readline

N = int(read().rstrip())

dp = [0] * 1_000_001

dp[1] = 1
dp[2] = 2

for i in range(3, 1_000_001):
    dp[i] = (dp[i-1] + dp[i-2]) % 15746

print(dp[N])
