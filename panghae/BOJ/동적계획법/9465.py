import sys

read = sys.stdin.readline

T = int(read().rstrip())

for _ in range(T):
    n = int(read().rstrip())

    sticker = [list(map(int, read().rstrip().split())) for _ in range(2)]

    dp = [[0] * (n + 1) for _ in range(2)]  # (해당 자리를 뗐을 때 값, 해당 자리를 안 뗐을 때 값)

    dp[0][1] = sticker[0][0]
    dp[1][1] = sticker[1][0]

    for j in range(2, n + 1):
        dp[0][j] = max(dp[1][j - 2], dp[1][j - 1]) + sticker[0][j - 1]
        dp[1][j] = max(dp[0][j - 2], dp[0][j - 1]) + sticker[1][j - 1]

    print(max(dp[1][n], dp[0][n]))
