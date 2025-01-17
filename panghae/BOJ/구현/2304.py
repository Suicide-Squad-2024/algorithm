import sys
from collections import deque

read = sys.stdin.readline

N = int(read().rstrip())

dp = [0] * 1001

max_point = 0
max_height = 0

for _ in range(N):
    point, height = map(int, read().rstrip().split())
    dp[point] = height
    if max_height < height:
        max_point = point
        max_height = height

answer = 0

height = 0

for i in range(max_point + 1):
    height = max(height, dp[i])
    answer += height

height = 0

for i in range(1000, max_point, -1):
    height = max(height, dp[i])
    answer += height

print(answer)
