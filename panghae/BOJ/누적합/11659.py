import sys

read = sys.stdin.readline

N, M = map(int, read().rstrip().split())

dp = [0] * (N + 1)

numbers = list(map(int, read().rstrip().split()))

for i in range(1, N + 1):
    dp[i] = dp[i - 1] + numbers[i - 1]

for _ in range(M):
    start, end = map(int, read().rstrip().split())
    print(dp[end] - dp[start - 1])
