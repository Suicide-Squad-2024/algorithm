import sys

read = sys.stdin.readline

n = int(read().rstrip())

drinks = [0] * 10001

for i in range(1, n + 1):
    drinks[i] = int(read().rstrip())

dp = [0] * 10001

dp[1] = drinks[1]
dp[2] = max(dp[1] + drinks[2], drinks[2])

for i in range(3, n + 1):
    dp[i] = max(dp[i - 3] + drinks[i - 1] + drinks[i], dp[i - 2] + drinks[i], dp[i - 1])

print(dp[n])
