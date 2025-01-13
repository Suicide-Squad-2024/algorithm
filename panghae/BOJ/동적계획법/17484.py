import sys
import math

read = sys.stdin.readline

N, M = map(int, read().rstrip().split())

route = [list(map(int, read().rstrip().split())) for _ in range(N)]

dp = [[[math.inf] * 3 for _ in range(M)] for _ in range(N)]

# 0 : 왼쪽 대각, 1: 아래, 2 : 오른쪽 대각

# 첫 번째 행 초기화
for j in range(M):
    for k in range(3):
        dp[0][j][k] = route[0][j]

for i in range(1, N):
    for j in range(M):
        for k in range(3):
            if k == 0 and j > 0:  # 왼쪽 대각선
                dp[i][j][k] = min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + route[i][j]
            elif k == 1:  # 아래
                dp[i][j][k] = min(dp[i - 1][j][0], dp[i - 1][j][2]) + route[i][j]
            elif k == 2 and j < M - 1:  # 오른쪽 대각선
                dp[i][j][k] = min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + route[i][j]

result = min(min(dp[N - 1][j]) for j in range(M))
print(result)
